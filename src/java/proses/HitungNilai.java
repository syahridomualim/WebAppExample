/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toshiba
 */
@WebServlet(name = "HitungNilai", urlPatterns = {"/HitungNilai"})
public class HitungNilai extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String hadir = request.getParameter("hadir");
        String pertemuan = request.getParameter("pertemuan");
        String tugas = request.getParameter("tugas");
        String uts = request.getParameter("uts");
        String uas = request.getParameter("uas");
        
        if (hadir == null) hadir = "";
        if (pertemuan == null) pertemuan = "";
        if (tugas == null) tugas = "";
        if (uts == null) uts = "";
        if (uas == null) uas = ""; 
        
        int jumlahHadir = 0;
        int jumlahPertemuan = 0;
        double nilaiTugas = 0.0;
        double nilaiUts = 0.0;
        double nilaiUas = 0.0;
        double nilaiAkhir;
        String grade;
        String status;
        
        try {
            jumlahHadir = Integer.parseInt(hadir);
        } catch (NumberFormatException e) {
        }
        try {
            jumlahPertemuan = Integer.parseInt(pertemuan);
        } catch (Exception e) {
        }
        try {
            nilaiTugas = Integer.parseInt(tugas);
        } catch (Exception e) {
        }
        try {
            nilaiUts = Integer.parseInt(uts);
        } catch (Exception e) {
        }
        try {
            nilaiUas = Integer.parseInt(uas);
        } catch (Exception e) {
        }
        
        nilaiAkhir = (10 * (double) jumlahHadir/jumlahPertemuan) + 0.2 * nilaiTugas + 0.3 * nilaiUts + 0.2 * nilaiUas;
        
        if ((nilaiAkhir >= 0) && (nilaiAkhir <= 100)) {
            if (nilaiAkhir >= 80) {
                grade = "A";
                status = "Lulus";
            } else if (nilaiAkhir >= 70) {
                grade = "B";
                status = "Lulus";
            } else if (nilaiAkhir >= 60) {
                grade = "C";
                status = "Lulus";
            } else if (nilaiAkhir >= 50) {
                grade = "D";
                status = "Tidak Lulus";
            } else {
                grade = "E";
                status = "Tidak Lulus";
            }
        } else {
            grade = "X";
            status = "X";
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HitungNilai</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Menghitung Nilai</h2>");
            out.println("<form action=HitungNilai method=post>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Jumlah hadir</td>");
            out.println("<td><input type=text name=hadir value="+ hadir +"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Jumlah pertemuan</td>");
            out.println("<td><input type=text name=pertemuan value="+ pertemuan +"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>Nilai tugas</td>");
            out.println("<td><input type=text name=tugas value="+ tugas +"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nilai UTS</td>");
            out.println("<td><input type=text name=uts value="+ uts +"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nilai UAS</td>");
            out.println("<td><input type=text name=uas value="+ uas +"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Nilai Akhir</td>");
            out.println("<td><input type=text readonly value="+ nilaiAkhir +"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Grade</td>");
            out.println("<td><input type=text readonly value="+ grade +"></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>Status</td>");
            out.println("<td><input type=text readonly value="+ status +"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=2 align=center><input type=submit value=Hitung></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}