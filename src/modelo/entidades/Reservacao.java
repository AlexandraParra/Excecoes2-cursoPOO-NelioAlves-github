package modelo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelo.excecoes.ExcecoesDominio;

public class Reservacao {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservacao() {
	}

	public Reservacao(Integer numeroQuarto, Date checkIn, Date checkOut) throws ExcecoesDominio {
		if (!checkOut.after(checkIn)) {
			throw new ExcecoesDominio ("A data do check-out deve ser depois da data do check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long periodo() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void atualizarDatas(Date checkIn, Date checkOut) throws ExcecoesDominio {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new ExcecoesDominio ("As datas de atualização deven ser futuras***");
		}
		if (!checkOut.after(checkIn)) {
			throw new ExcecoesDominio ("A data do check-out deve ser depois da data do check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
	return "Reservação: Quarto "
			+ numeroQuarto
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ periodo()
			+ " noites";
	}
}
