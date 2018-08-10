package hsbc.team03.ordersystem.displayproduct.common;

import hsbc.team03.ordersystem.displayproduct.Log;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:Evan
 * @Date:2018/8/9 10:36
 * @Describe：
 * @Return:
 * @Param:
 */
public class SystemLogTool {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public List<Log> screeningSystemLog(int n, List<Log> logList) throws ParseException {

        int i = 0;
        /*得到当前时间并转换成时间类型*/
        String currentTime = sdf.format(new Date());
        Date currentTime1 = sdf.parse(currentTime);
        List<Log> logs = new ArrayList<>();
        Iterator<Log> it = logList.iterator();
        while (it.hasNext()) {
            /*get the systemlog 's time and parse to date type*/
            Date logTime = sdf.parse(it.next().getTime());
            if ((int) ((currentTime1.getTime() - logTime.getTime()) / (1000 * 3600 * 24)) > n) {
                it.remove();
            }
        }
       /* for (int i = 0; i < logList.size(); i++) {
            Date logTime = sdf.parse(logList.get(i).getTime());
            if ((int) ((currentTime1.getTime() - logTime.getTime()) / (1000 * 3600 * 24)) <= n) {
                System.out.println((int) ((currentTime1.getTime() - logTime.getTime()) / (1000 * 3600 * 24)));
                logs.add(logList.get(i));
            }
        }*/
        return logList;
    }

    public String exportSystomLogToExcel(List<Log> logs, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("系统日志");

        String fileName = "systemlog" + ".xls";
        //新增数据行，并且设置单元格数据
        int rowNum = 1;

        //headers表示excel表中第一行的表头
        String[] headers = {"序号", "用户名", "操作", "时间"};

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (Log log : logs) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(rowNum);
            row1.createCell(1).setCellValue(log.getName());
            row1.createCell(2).setCellValue(log.getOperation());
            row1.createCell(3).setCellValue(log.getTime());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
        return "SCUESS";
    }

}
