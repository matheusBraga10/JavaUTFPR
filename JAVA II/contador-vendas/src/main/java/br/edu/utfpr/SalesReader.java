package br.edu.utfpr;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.bean.CsvToBeanBuilder;

import br.edu.utfpr.Sale.Status;

public class SalesReader {

	private final List<Sale> sales;

	public SalesReader(String salesFile) {

		final var dataStream = ClassLoader.getSystemResourceAsStream(salesFile);

		if (dataStream == null) {
			throw new IllegalStateException("File not found or is empty");
		}

		try (InputStreamReader reader = new InputStreamReader(dataStream, StandardCharsets.UTF_8)) {
			sales = new CsvToBeanBuilder<Sale>(reader).withType(Sale.class).withSeparator(';').build().parse();

		} catch (Exception e) {
			throw new RuntimeException("Leitura do arquivo CVS falhou.", e);
		}
	}

	public BigDecimal totalOfCompletedSales() {
		if (sales == null || sales.isEmpty()) {
			return BigDecimal.ZERO;
		}
		return sales.stream().filter(sale -> Status.COMPLETED.equals(sale.getStatus())).map(Sale::getValue)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal totalOfCancelledSales() {
		if (sales == null || sales.isEmpty()) {
			return BigDecimal.ZERO;
		}
		return sales.stream().filter(sale -> Status.CANCELLED.equals(sale.getStatus())).map(Sale::getValue)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public Optional<Sale> mostRecentCompletedSale() {
		if (sales == null || sales.isEmpty()) {
			return Optional.empty();
		}
		return sales.stream().filter(sale -> Status.COMPLETED.equals(sale.getStatus()))
				.max(Comparator.comparing(Sale::getSaleDate));
	}

	public long daysBetweenFirstAndLastCancelledSale() {
		if (sales == null || sales.isEmpty()) {
			return 0;
		}
		Optional<LocalDate> dataMaisRecente = sales.stream().filter(sale -> Status.CANCELLED.equals(sale.getStatus()))
				.map(Sale::getSaleDate).max(Comparator.naturalOrder());

		Optional<LocalDate> dataMaisAntiga = sales.stream().filter(sale -> Status.CANCELLED.equals(sale.getStatus()))
				.map(Sale::getSaleDate).min(Comparator.naturalOrder());

		if (dataMaisAntiga.isPresent() && dataMaisRecente.isPresent()) {
			return ChronoUnit.DAYS.between(dataMaisAntiga.get(), dataMaisRecente.get());
		}
		return 0;
	}

	public BigDecimal totalCompletedSalesBySeller(String sellerName) {
		if (sales == null || sales.isEmpty()) {
			return BigDecimal.ZERO;
		}
		return sales.stream().filter(sale -> Status.COMPLETED.equals(sale.getStatus()))
				.filter(sale -> sellerName.equalsIgnoreCase(sale.getSeller())).map(Sale::getValue)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public long countAllSalesByManager(String managerName) {
		if (sales == null || sales.isEmpty() || managerName == null) {
			return 0;
		}
		return sales.stream().filter(sale -> managerName.equalsIgnoreCase(sale.getManager())).count();

	}

	public BigDecimal totalSalesByStatusAndMonth(Sale.Status status, Month... months) {
		if (sales == null || sales.isEmpty() || months == null || status == null) {
			return BigDecimal.ZERO;
		}
		return sales.stream().filter(sale -> status.equals(sale.getStatus()))
				.filter(sale -> Stream.of(months).anyMatch(month -> month.equals(sale.getSaleDate().getMonth())))
				.map(Sale::getValue).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public Map<String, Long> countCompletedSalesByDepartment() {
		if (sales == null || sales.isEmpty()) {
			return Map.of();
		}
		return sales.stream().filter(sale -> Status.COMPLETED.equals(sale.getStatus()))
				.collect(Collectors.groupingBy(Sale::getDepartment, Collectors.counting()));
	}

	public Map<Integer, Map<String, Long>> countCompletedSalesByPaymentMethodAndGroupingByYear() {
		if (sales == null || sales.isEmpty()) {
			return Map.of();
		}
		return sales.stream().filter(sale -> Status.COMPLETED.equals(sale.getStatus()))
				.collect(Collectors.groupingBy(sale -> sale.getSaleDate().getYear(),
						Collectors.groupingBy(Sale::getPaymentMethod, Collectors.counting())));
	}

	public Map<String, BigDecimal> top3BestSellers() {
		if (sales == null || sales.isEmpty()) {
			return Map.of();
		}
		Map<String, BigDecimal> totalVendedor = sales.stream().filter(sale -> Status.COMPLETED.equals(sale.getStatus()))
				.collect(Collectors.groupingBy(Sale::getSeller,
						Collectors.mapping(Sale::getValue, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));

		Map<String, BigDecimal> top3 = totalVendedor.entrySet().stream()
				.sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed()).limit(3)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return top3;
	}
	

}