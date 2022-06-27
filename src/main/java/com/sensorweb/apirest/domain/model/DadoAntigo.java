/*
 * package com.sensorweb.apirest.domain.model;
 * 
 * import java.math.BigDecimal;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id;
 * 
 * import org.hibernate.annotations.GenericGenerator;
 * 
 * import lombok.Data; import lombok.EqualsAndHashCode;
 * 
 * @Entity
 * 
 * @Data
 * 
 * @EqualsAndHashCode(onlyExplicitlyIncluded = true) public class DadoAntigo {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @EqualsAndHashCode.Include private Long id;
 * 
 * // For Postgres // @Id // @GeneratedValue(generator = "increment")
 * // @GenericGenerator(name = "increment", strategy = "increment")
 * // @EqualsAndHashCode.Include // private Long id;
 * 
 * private BigDecimal dado;
 * 
 * // @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
 * // @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
 * 
 * @Column(columnDefinition = "datetime") private String ts;
 * 
 * public DadoAntigo() {
 * 
 * }
 * 
 * }
 */