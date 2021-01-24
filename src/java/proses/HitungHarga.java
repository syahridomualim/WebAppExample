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
@WebServlet(name = "HitungHarga", urlPatterns = {"/HitungHarga"})
public class HitungHarga extends HttpServlet {

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
        String namaBarang = request.getParameter("namaBarang");
        String hargaSatuan = request.getParameter("hargaSatuan");
        String jumlah = request.getParameter("jumlah");
        int harga =  0;
        int jumlahBarang = 0;
        int diskon = 0;
        int total;
        
        try {
            harga = Integer.parseInt(hargaSatuan);
        } catch (NumberFormatException e) {
        }
        
        try {
            jumlahBarang = Integer.parseInt(jumlah);
        } catch (NumberFormatException e) {
        }
        
        total = harga * jumlahBarang;
        
        if ((jumlahBarang >= 100) && (total >= 1000000)) {
            diskon = ((int) (total * 0.05));
            total -= diskon;
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HitungHarga</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Hasil Penggitungan Harga</h2>");
            out.println("<form action=index.jsp method=post>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Nama Barang</td><td>:</td><td>" + namaBarang +"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Harga Satuan</td><td>:</td><td>" + hargaSatuan +"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td>Jumlah</td><td>:</td><td>" + jumlah +"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Diskon</td><td>:</td><td>" + diskon +"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Total</td><td>:</td><td>" + total +"</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=3><input type=submit value=Kembali></td>");
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
