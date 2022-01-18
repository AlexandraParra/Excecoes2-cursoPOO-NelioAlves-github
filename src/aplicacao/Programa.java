package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.Reservacao;
import modelo.excecoes.ExcecoesDominio;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		try {
			System.out.print("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data check-in (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			Reservacao reservacao = new Reservacao(numeroQuarto, checkIn, checkOut);
			System.out.println(reservacao);
			
			System.out.println();
			System.out.println("Dados atualizados da reservação");
			System.out.print("Data check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			reservacao.atualizarDatas(checkIn, checkOut);
			System.out.println(reservacao);
		} 
		catch (ExcecoesDominio e){
			System.out.println("Erro na reservação: "+ e.getMessage());
		}
		catch(ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (RuntimeException e){
			System.out.println("Erro inesperado");
		}
		
		sc.close();
	}
}
