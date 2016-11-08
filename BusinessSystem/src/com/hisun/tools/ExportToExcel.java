package com.hisun.tools;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

public class ExportToExcel<T> {

	public void ExportToExcel(Collection<T> dataset, OutputStream out) {
		ExportToExcel("�¼��鿴", null, dataset, out, "yyyy-MM-dd");
	}

	public void ExportToExcel(String[] headers, Collection<T> dataset,OutputStream out) throws Exception {

		ExportToExcel("�¼��鿴", headers, dataset, out, "yyyy-MM-dd");

	}

	public void ExportToExcel(String[] headers, Collection<T> dataset,OutputStream out, String pattern) {

		ExportToExcel("�¼��鿴", headers, dataset, out, pattern);

	}

	@SuppressWarnings("unchecked")
	public void ExportToExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern) {

		// ����һ��������
		HSSFWorkbook workbook = new HSSFWorkbook();
		// ����һ�����
		HSSFSheet sheet = workbook.createSheet(title);
		// ���ñ��Ĭ���п��Ϊ15���ֽ�
		sheet.setDefaultColumnWidth((short) 15);
		// ����һ����ʽ
		HSSFCellStyle style = workbook.createCellStyle();
		// ������Щ��ʽ
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// ����һ������
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������Ӧ�õ���ǰ����ʽ
		style.setFont(font);
		// ���ɲ�������һ����ʽ
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// ������һ������
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// ������Ӧ�õ���ǰ����ʽ
		style2.setFont(font2);
		// ������������
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i); 
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}

		// �����������ݣ�����������
		Iterator<T> it = dataset.iterator();
		int index = 0;
		while (it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T t = (T) it.next();
			// ���÷��䣬����javabean���Ե��Ⱥ�˳�򣬶�̬����getXxx()�����õ�����ֵ
			Field[] fields = t.getClass().getDeclaredFields();
			for (short i = 0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get"
				+ fieldName.substring(0, 1).toUpperCase()
				+ fieldName.substring(1);
				try {
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
					new Class[] {});
					Object value = getMethod.invoke(t, new Object[] {});
					// �ж�ֵ�����ͺ����ǿ������ת��
					String textValue = null;
					/**-----------------------------------------------------------*/
					// if (value instanceof Integer) {
					// int intValue = (Integer) value;

					// cell.setCellValue(intValue);

					// } else if (value instanceof Float) {

					// float fValue = (Float) value;

					// textValue = new HSSFRichTextString(

					// String.valueOf(fValue));

					// cell.setCellValue(textValue);

					// } else if (value instanceof Double) {

					// double dValue = (Double) value;

					// textValue = new HSSFRichTextString(

					// String.valueOf(dValue));

					// cell.setCellValue(textValue);

					// } else if (value instanceof Long) {

					// long longValue = (Long) value;

					// cell.setCellValue(longValue);

					// }
					/**-----------------------------------------------------------*/
					if (value instanceof Boolean) {

						boolean bValue = (Boolean) value;

						textValue = "��";

						if (!bValue) {

							textValue = "Ů";

						}

					} else if (value instanceof Date) {

						Date date = (Date) value;

						SimpleDateFormat sdf = new SimpleDateFormat(pattern);

						textValue = sdf.format(date);
						
					}else if (value ==null){
						textValue ="";
					} else  {
						// �����������Ͷ������ַ����򵥴���
						textValue = value.toString();
					}

					// �������ͼƬ���ݣ�������������ʽ�ж�textValue�Ƿ�ȫ�����������

					if (textValue != null) {

						Pattern p = Pattern.compile("^//d+(//.//d+)?$");

						Matcher matcher = p.matcher(textValue);

						if (matcher.matches()) {

							// �����ֵ���double����

							cell.setCellValue(Double.parseDouble(textValue));

						} else {

							HSSFRichTextString richString = new HSSFRichTextString(
									textValue);

							HSSFFont font3 = workbook.createFont();

							font3.setColor(HSSFColor.BLUE.index);

							richString.applyFont(font3);

							cell.setCellValue(richString);

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {

					// ������Դ

				}

			}

		}

		try {

			workbook.write(out);

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}
}
