package chessApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chessIO.IOService;
import chessIO.ServletIO;
import domain.Position;
import domain.pieces.Piece;
import trash.Player;


public class Match extends HttpServlet{

	private static final long serialVersionUID = 5845158140788975034L;
	private App game;
	private IOService io = new ServletIO();
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		game = new App();
		game.main(
			io,
			new Player("Jóska", true),
			new Player("Benedek", false)
		);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        drawPage(out);

	}
	private void drawPage(PrintWriter out) {
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<link rel='stylesheet' type='text/css' href='css/style.css'/>");

        out.println("<title> chessMatch </title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<h3>Chess Match</h3>");
        out.println("<h2>Player1 vs Player2</h2>");
        drawTable(out);
        out.println("</body>");
	}
	
	private void drawTable(PrintWriter out) {
		out.println("<table>");
		Map <Position, Piece> pieces = io.getPieces(game.getBoard());
		Piece piece;
		for (int i = 8; i > 0; i--) {
			out.println("<tr id =\"" + i + "\">");
			for (int j = 0; j < 8; j++) {
				piece = pieces.get(new Position(i, j));
				out.println("<td id =\"" + (char)(j + Position.FILE_MIN) + "\">");
				if((i + j) % 2 == 0)
					out.println("<div class = \"light_tile\"/>");
				else
					out.println("<div class = \"dark_tile\"/>");
				if(piece != null)
					out.println("<div class = \""+getPieceClass(piece)+"\"/>");
				out.println("</td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		
	}
	private String getPieceClass(Piece piece) {
		String out;
		if(piece.getOwner().isLightPlayer())
			out = "l_";
		else 
			out = "d_";
		out.concat(piece.getClass().getPackageName().toLowerCase());
		return out;
	}
}
