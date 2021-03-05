package accountingsystem.main.service;


import accountingsystem.main.model.Turnover;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class TestPDFExporter {
    private List<Turnover> turnoverList;

    public TestPDFExporter() {
    }

    public TestPDFExporter(List<Turnover> turnoverList) {
        this.turnoverList = turnoverList;
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Turnover", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        document.close();
    }
}
