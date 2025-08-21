package co.com.tgc.currentaccount.model.entity;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import co.com.tgc.currentaccount.util.Constants;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="conceptos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concepto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Builder.Default
	private UUID id = UUID.randomUUID();
	private String tipo;
	private String nombre;
	@Builder.Default
	private Instant fechaActualizacion = Instant.now();
	private String usuarioActualizacion;
}
