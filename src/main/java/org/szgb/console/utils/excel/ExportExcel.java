package org.szgb.console.utils.excel;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Excel导出工具类
 *
 * @author szgb
 * @version 0.2.2024.10.29
 */
public class ExportExcel {
    /**
     * Excel工作簿对象
     */
    private XSSFWorkbook wb;
    /**
     * 当前工作表对象
     */
    private XSSFSheet sheet;
    /**
     * 工作表对象集合
     */
    private List<XSSFSheet> sheetList;
    /**
     * 当前行位置
     */
    @Getter
    private int currentRowIndex;
    /**
     * 当前行对象
     */
    private Row row;
    /**
     * 当前单元格位置
     */
    @Getter
    private int currentCellIndex;
    /**
     * 表格单元格对象
     */
    private Cell cell;
    /**
     * 合并单元格对象
     */
    private CellRangeAddress cellAddresses;
    /**
     * 表格样式对象
     */
    private XSSFCellStyle cellStyle;


    public ExportExcel() {
        wb = new XSSFWorkbook();
        sheetList = new ArrayList<>();
        currentRowIndex = 0;
        currentCellIndex = 0;
        cellAddresses = new CellRangeAddress(0, 0, 0, 0);
        cellStyle = wb.createCellStyle();
    }

    /**
     * 设置当前行索引
     *
     * @param currentRowIndex 当前行索引
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel setCurrentRowIndex(int currentRowIndex) {
        this.currentRowIndex = currentRowIndex;
        return this;
    }

    /**
     * 设置当前单元格索引
     *
     * @param currentCellIndex 当前单元格索引
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel setCurrentCellIndex(int currentCellIndex) {
        this.currentCellIndex = currentCellIndex;
        return this;
    }

    /**
     * 创建一个新的工作表并命名
     * 此方法首先通过WorkbookUtil.createSafeSheetName()方法确保工作表名称的安全性，
     * 然后使用Workbook对象的createSheet()方法创建新的工作表
     *
     * @param sheetName 希望创建的工作表的名称
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel createSheet(String sheetName) {
        // 确保工作表名称的安全性
        String safeName = WorkbookUtil.createSafeSheetName(sheetName);
        // 使用安全的工作表名称创建新的工作表
        sheet = wb.createSheet(safeName);
        // 将新创建的工作表添加到工作表列表中
        sheetList.add(sheet);
        // 重置当前行索引
        currentRowIndex = 0;
        // 重置当前单元格索引
        currentCellIndex = 0;
        return this;
    }

    /**
     * 设置单元格内容的对齐方式
     * 此方法允许调用者指定单元格内容的水平和垂直对齐方式，以精确控制表格中内容的显示位置
     *
     * @param horAlign 水平对齐方式，指定内容在单元格内的水平位置
     * @param verAlign 垂直对齐方式，指定内容在单元格内的垂直位置
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel setCellAlignment(HorizontalAlignment horAlign, VerticalAlignment verAlign) {
        // 设置单元格内容的水平对齐方式
        cellStyle.setAlignment(horAlign);
        // 设置单元格内容的垂直对齐方式
        cellStyle.setVerticalAlignment(verAlign);
        return this;
    }

    /**
     * 设置并合并单元格地址
     * 此方法用于指定工作表中一个区域的起始和结束位置，并将其合并为一个单元格
     *
     * @param firstRow    起始行号
     * @param lastRow     结束行号
     * @param firstColumn 起始列号
     * @param lastColumn  结束列号
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel mergeCells(int firstRow, int lastRow, int firstColumn, int lastColumn) {
        // 设置起始行号
        cellAddresses.setFirstRow(firstRow);
        // 设置结束行号
        cellAddresses.setLastRow(lastRow);
        // 设置起始列号
        cellAddresses.setFirstColumn(firstColumn);
        // 设置结束列号
        cellAddresses.setLastColumn(lastColumn);
        // 将指定区域的单元格合并
        sheet.addMergedRegion(cellAddresses);
        return this;
    }

    /**
     * 合并单元格函数的重载版本，用于根据相对位置合并单元格
     * 此方法通过指定当前单元格的宽度和高度来合并单元格，而不是具体的起始和结束行列索引
     * 它提供了一种更直观的方式来合并单元格，特别是当用户更关心合并区域的大小而非具体位置时
     *
     * @param height 要合并的单元格的高度（行数）
     * @param width  要合并的单元格的宽度（列数）
     * @return 返回一个ExportExcel对象，允许进行链式调用或其他操作
     */
    public ExportExcel mergeCells(int height, int width) {
        // 调用另一个mergeCells方法，传入当前行索引、当前行索引加上宽度、当前列索引、当前列索引加上高度
        // 这种设计允许通过相对位置来合并单元格，而不是每次都计算绝对的行列索引
        mergeCells(currentRowIndex - 1, currentRowIndex - 2 + height, currentCellIndex,
                currentCellIndex + width - 1);
        return this;
    }

    /**
     * 创建一个新的行对象
     * 此方法用于在当前操作的电子表格中创建一个新的行对象
     * 它通过调用sheet对象的createRow方法，并传递当前行索引来实现
     * 在创建行之后，当前行索引将自增，以准备下一次创建行操作
     *
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel createRow() {
        // 在当前行索引位置创建一个新的行对象
        row = sheet.createRow(currentRowIndex);
        // 当前行索引自增，以准备下一行的创建
        currentRowIndex++;
        // 将当前单元格索引重置为0，用于在新行中创建单元格
        currentCellIndex = 0;
        return this;
    }

    /**
     * 创建一个新的行，并设置当前操作的行索引和单元格索引
     * 此方法用于在指定的行索引位置创建一个新的行对象，并重置当前操作的行和单元格索引
     *
     * @param rowIndex 新行的索引位置
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel createRow(int rowIndex) {
        row = sheet.createRow(rowIndex);
        currentRowIndex = rowIndex + 1;
        currentCellIndex = 0;
        return this;
    }

    /**
     * 创建并设置单元格
     * 此方法用于在当前行中创建一个新的单元格，并为其设置预定的样式和值。
     * 它依赖于外部定义的行对象和当前单元格索引，以确定新单元格的位置。
     *
     * @param value 要设置在新单元格中的字符串值
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel createCell(String value) {
        // 创建一个新的单元格，并将其位置设置为当前单元格索引
        cell = row.createCell(currentCellIndex);
        // 为新创建的单元格设置预定义的样式
        cell.setCellStyle(cellStyle);
        // 将指定的值设置到单元格中
        cell.setCellValue(value);
        // 当前单元格索引自增，以准备下一单元格的创建
        currentCellIndex++;
        return this;
    }

    /**
     * 批量创建Excel单元格并赋值
     * 此方法接收一个字符串数组，为每个字符串创建一个Excel单元格并赋值。
     * 它内部调用了 {@link #createCell(String)} 方法来逐个创建单元格。
     * 主要作用是简化多个单元格创建的流程，提高代码可读性和效率。
     *
     * @param values 可变参数，代表要创建的Excel单元格的值
     * @return 返回ExportExcel对象，支持链式调用
     */
    public ExportExcel createCell(String... values) {
        // 遍历每个传入的字符串值
        for (String value : values) {
            // 调用createCell方法为当前值创建一个Excel单元格
            createCell(value);
        }
        // 返回ExportExcel对象实例，支持链式调用
        return this;
    }


    /**
     * 创建并设置日期单元格
     * 根据给定的日期和格式模式，将日期格式化为字符串，并创建一个包含该字符串的单元格
     * 主要用于在表格中创建日期列或行，其中日期以特定格式显示
     *
     * @param date    日期对象，表示要格式化和显示的日期
     * @param pattern 字符串，指定日期的格式模式，例如"yyyy-MM-dd"
     *                该模式用于确定日期的显示格式
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel createCell(Date date, String pattern) {
        // 格式化日期对象为指定模式的日期字符串，并创建单元格
        createCell(new SimpleDateFormat(pattern, Locale.CHINA).format(date));
        return this;
    }

    /**
     * 输出数据流
     *
     * @param os 输出数据流
     * @return 返回当前的ExportExcel对象，支持链式调用
     */
    public ExportExcel write(OutputStream os) throws IOException {
        wb.write(os);
        return this;
    }

    public ExportExcel write(HttpServletResponse response, String fileName) throws IOException {
        try {
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,
                    StandardCharsets.UTF_8));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");

            try (OutputStream os = response.getOutputStream()) {
                wb.write(os);
                os.flush();
            }
        } catch (UnsupportedEncodingException e) {
            // 处理编码异常
            throw new IOException("Failed to encode file name: " + fileName, e);
        } catch (IOException e) {
            // 处理 I/O 异常
            throw new IOException("Failed to write to output stream", e);
        }
        return this;
    }

}
