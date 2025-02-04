package com.example.myapp

import android.content.Context
import android.widget.Toast
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.layout.Document
import com.itextpdf.layout.element.Paragraph
import java.io.File

class PdfExporter {

    fun exportRecords(context: Context, records: List<Record>) {
        val pdfPath = "${context.getExternalFilesDir(null)?.absolutePath}/records.pdf"
        val writer = PdfWriter(pdfPath)
        val pdfDoc = PdfDocument(writer)
        val document = Document(pdfDoc)

        records.forEach { record ->
            document.add(Paragraph("Title: ${record.title}"))
            document.add(Paragraph("Description: ${record.description}"))
            document.add(Paragraph("Category: ${record.category}"))
            document.add(Paragraph("Date: ${record.date}"))
            document.add(Paragraph("Priority: ${record.priority}"))
            document.add(Paragraph("-----------------------------------"))
        }

        document.close()
        Toast.makeText(context, "PDF exported successfully", Toast.LENGTH_SHORT).show()
    }
}
