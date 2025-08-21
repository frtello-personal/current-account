package co.com.tgc.currentaccount.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="cuentas")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Builder.Default
	private UUID id = UUID.randomUUID();
	private UUID idCliente;
	private Integer impuesto;
	@Builder.Default
	private Instant fechaActualizacion = Instant.now();
	private String usuarioActualizacion;
	@OneToMany(mappedBy="cuenta")
	private Set<Debito> debitos;
	@OneToMany(mappedBy="cuenta")
	private Set<Credito> creditos;
}
