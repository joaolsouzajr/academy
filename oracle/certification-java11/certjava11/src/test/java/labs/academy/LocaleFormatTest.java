package labs.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalField;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.jupiter.api.Test;

public class LocaleFormatTest {

	@Test
	public void durationTest() {
		// Duration represente an amount of time in seconds and nanoseconds
		Duration oneHour = Duration.ofHours(1);

		assertEquals(3600, oneHour.getSeconds());
		assertEquals(3601, oneHour.plusSeconds(1).getSeconds());
		assertEquals(3600, oneHour.getSeconds());
	}

	@Test
	public void periodTest() {
		// Period represent an amount of time in years, days,
		LocalDate today = LocalDate.now();
		LocalDate myDay = LocalDate.of(1986, Month.APRIL, 13);

		Period period = Period.between(myDay, today);

		assertEquals(1986, myDay.getYear());
		assertEquals(35, today.getYear() - myDay.getYear());
		//assertEquals(34, period.getYears());
		assertTrue(12435 > period.getYears() * Month.values().length + period.getDays());

	}
	
	@Test
	public void finddayTest() {
		// Period represent an amount of time in years, days,
		LocalDate myDay = LocalDate.of(1986, Month.of(4), 13);

	
		assertEquals(DayOfWeek.SUNDAY.name(), myDay.getDayOfWeek().name());

	}

	@Test
	public void zoneTest() {
		
		ZoneId london = ZoneId.of("Europe/London");
		ZoneId fortaleza = ZoneId.of("America/Fortaleza");
		LocalDateTime sameTime =  LocalDateTime.of(2020, Month.APRIL, 13, 13,00);
		ZonedDateTime londonTime = ZonedDateTime.of(sameTime, london);
		//conter date time to another time zone
		ZonedDateTime fortalezaTime = londonTime.withZoneSameInstant(fortaleza);
		
		
		assertEquals(13, londonTime.getHour());
		assertEquals(9, fortalezaTime.getHour());
		
	}
	
	@Test
	public void localeTest() throws ParseException {
		BigDecimal price = BigDecimal.valueOf(2.99);
		Double tax=  0.2;
		int quantity = 12345;
		
		Locale locale = new Locale("en", "US");
		
		var currecnyFormat = NumberFormat.getCurrencyInstance(locale);
		var percentageFormat = NumberFormat.getPercentInstance(locale);
		var numberFormat = NumberFormat.getNumberInstance(locale);
		
		assertEquals("$2.99", currecnyFormat.format(price));
		assertEquals("20%", percentageFormat.format(tax));
		assertEquals("12,345", numberFormat.format(quantity));
		
		assertEquals(price, BigDecimal.valueOf((Double)currecnyFormat.parse("$2.99")));
		assertEquals(tax, (Double) percentageFormat.parse("20%"));
		assertEquals(quantity, numberFormat.parse("12,345").intValue());
	}
	
	
	@Test
	public void boundleTest() {
		Locale localeEn = new Locale("en", "US");
		Locale localeEs = new Locale("es");
		
		var resourceBundle =  ResourceBundle.getBundle("messages");
		var resourceBundleEn =  ResourceBundle.getBundle("messages", localeEn);
		var resourceBundleEs =  ResourceBundle.getBundle("messages", localeEs);
		
		assertEquals("Olá", resourceBundle.getString("hello"));
		assertEquals("Hello", resourceBundleEn.getString("hello"));
		assertEquals("Hola", resourceBundleEs.getString("hello"));
	}
	
	@Test
	public void messageFormatTest() throws ParseException {
		//given
		var name = "Cookie";
		BigDecimal price = BigDecimal.valueOf(2.99);
		int quantity = 12345;
		Locale locale = new Locale("en", "US");
		LocalDate date = LocalDate.of(2021, Month.APRIL, 13); 
		
		
		//when
		var resourceBundle =  ResourceBundle.getBundle("messages");
		var currecnyFormat = NumberFormat.getCurrencyInstance();
		var numberFormat = NumberFormat.getNumberInstance();
		
		
		var priceStr = currecnyFormat.format(price); 
		var quantityStr = numberFormat.format(quantity);
		var dateStr = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
		
		
		var pattern = resourceBundle.getString("product");
		
		//then
		assertEquals("Cookie, preço R$ 2,99, quantidade 12.345, melhor data 13 de abr de 2021", 
				MessageFormat.format(pattern, name, priceStr, quantityStr, dateStr));
		
		//when
		resourceBundle =  ResourceBundle.getBundle("messages", locale);
		pattern = resourceBundle.getString("product");
		currecnyFormat = NumberFormat.getCurrencyInstance(locale);
		numberFormat = NumberFormat.getNumberInstance(locale);
		
		priceStr = currecnyFormat.format(price); 
		quantityStr = numberFormat.format(quantity);
		dateStr = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).localizedBy(locale));
		
		pattern = resourceBundle.getString("product");
		
		//then
		assertEquals("Cookie, price $2.99, quantity 12,345, best before Apr 13, 2021 ", 
				MessageFormat.format(pattern, name, priceStr, quantityStr, dateStr));
	}

	

}
