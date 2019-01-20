package com.dpa.General;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class Pdf {
	public int generatePdf(DegreePlan degreePlan, GRE gre, List<Courses> courses){
	Document document = new Document();
    try
    {
       PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("DegreePlan.pdf"));
       document.open();
       document.add(new Paragraph("Department of Computer Science and Engineering", FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Master's Degree Plan", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 16, BaseColor.GREEN)));
       document.add(new Paragraph(new Date().toString(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 16, BaseColor.BLACK)));
       document.add(new Paragraph("-----------------------------------------------------------------------------------------------------------------------"));
       document.add(new Paragraph("Name: " + degreePlan.getName() + "                                        " + "Student Id: " + "11267588", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Local Address: " + degreePlan.getLocalAddress(), FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("E Mail Address: " + degreePlan.getEmail(), FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Degree to be earned: " + degreePlan.getDegree() + "                               " + "Major: " + "Computer Science", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Minor: " + degreePlan.getMinor() + "      " + "Interest Area: " + degreePlan.getInterestArea(), FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Major Professor: " + degreePlan.getMajorProfessor(), FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Most recent GRE scores: Verbal: " + gre.getVerbal() + "  " + "Quantitative: " + gre.getQuantitative() + "  " + "Analytical: " + gre.getAnalytical() + "  " + "Date Taken: " + gre.getDateTaken(), FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       
       //core courses
       document.add(new Paragraph("Core Courses", FontFactory.getFont(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK))); 
       PdfPTable table1 = new PdfPTable(6);
       PdfPCell cell2 = new PdfPCell(new Phrase("Course Prefix, Number and Title"));
       cell2.setColspan(3);
       	  table1.addCell(cell2);
	      table1.addCell("Semester Taken");
	      table1.addCell("C. Hrs");
	      table1.addCell("Grade");
       for(Courses course:courses){  
    	   if(!(course.getCourseCatergory().equals("optional"))){
    		   PdfPCell celli = new PdfPCell(new Phrase(course.getCourse()));
    	       celli.setColspan(3);
    	          table1.addCell(celli);
    		      table1.addCell(course.getSemesterTaken());
    		      table1.addCell("C.Hrs: " + course.getcHrs());
    		      table1.addCell(course.getGrade());
    	   }
       }
       table1.setSpacingBefore(15f);
	   document.add(table1);
	   table1.setSpacingAfter(10f);
       //Optional courses
       document.add(new Paragraph("Supporting Courses", FontFactory.getFont(FontFactory.TIMES_BOLD, 14, BaseColor.BLACK)));
       PdfPTable table = new PdfPTable(6);
       PdfPCell cell1 = new PdfPCell(new Phrase("Course Prefix, Number and Title"));
       cell1.setColspan(3);
       	  table.addCell(cell1);
	      table.addCell("Semester Taken");
	      table.addCell("C. Hrs");
	      table.addCell("Grade");
       for(Courses course:courses){
    	   if(course.getCourseCatergory().equals("optional")){
    		   PdfPCell celli = new PdfPCell(new Phrase(course.getCourse()));
    	       celli.setColspan(3);
    	          table.addCell(celli);
    		      table.addCell(course.getSemesterTaken());
    		      table.addCell("C.Hrs: " + course.getcHrs());
    		      table.addCell(course.getGrade());
    	   }       
       }
       table.setSpacingBefore(15f);
	   document.add(table);
	   table.setSpacingAfter(10f);
	   
	   document.add(new Paragraph("Admission to candidacy is recommended: " + "            " + "Total Semester Hours Required: " + "36", FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK))); 
       //major professor signature
       document.add(new Paragraph("Advisor or Major Professor: " + degreePlan.getProfessorSignature(), FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Associate Chair for Graduate Studies: " + degreePlan.getAssociateChairSignature(), FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Department Chair:  " + degreePlan.getChairSignature(), FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       
       document.close();
       writer.close();
    } catch (DocumentException ex)
    {
       ex.printStackTrace();
    } catch (FileNotFoundException e)
    {
       e.printStackTrace();
    }
	return 1;
	}
}

