/*
 * package com.sensorweb.apirest.domain.model;
 * 
 * import java.util.List; import java.util.Vector;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.OneToMany;
 * 
 * import org.hibernate.annotations.GenericGenerator;
 * 
 * import lombok.Data; import lombok.EqualsAndHashCode;
 * 
 * @Entity
 * 
 * @Data
 * 
 * @EqualsAndHashCode(onlyExplicitlyIncluded = true) public class PontoAntigo {
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
 * private String nome; private String xid;
 * 
 * // @OneToMany // @JoinColumn(name = "ponto_id") // private List<DadoAntigo> dados =
 * new Vector<DadoAntigo>();
 * 
 * }
 */