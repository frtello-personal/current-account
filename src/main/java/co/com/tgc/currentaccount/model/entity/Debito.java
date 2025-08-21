package co.com.tgc.currentaccount.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="debitos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Debito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Builder.Default
	private UUID id = UUID.randomUUID();
	@ManyToOne
	@JoinColumn(name="id_cuenta")
	private Cuenta cuenta;
	@ManyToOne
	@JoinColumn(name="id_concepto")
	private Concepto concepto;
	private Integer periodo;
	private BigDecimal valor;
	private UUID idDocumento;
	private Instant fechaTransaccion;
	private Instant fechaRegistro;
	private String usuarioActualizacion;
}
