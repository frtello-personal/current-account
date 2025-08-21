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

/**
 * Represents a credit transaction in the current account system.
 * This entity is mapped to the "creditos" table in the database.
 *
 * <p>Each credit transaction is associated with a specific account and concept,
 * and includes details such as the period, value, document ID, transaction date,
 * registration date, and the user who updated the record.</p>
 *
 * <p>Annotations are used to define the entity and its relationships:</p>
 * <ul>
 *   <li>@Entity - Specifies that the class is an entity.</li>
 *   <li>@Table(name="creditos") - Maps the entity to the "creditos" table.</li>
 *   <li>@Id - Marks the primary key field.</li>
 *   <li>@ManyToOne - Defines a many-to-one relationship with another entity.</li>
 *   <li>@JoinColumn - Specifies the foreign key column.</li>
 * </ul>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * Credito credito = Credito.builder()
 *     .cuenta(cuenta)
 *     .concepto(concepto)
 *     .periodo(2023)
 *     .valor(new BigDecimal("100.00"))
 *     .idDocumento(UUID.randomUUID())
 *     .fechaTransaccion(Instant.now())
 *     .usuarioActualizacion("user123")
 *     .build();
 * }
 * </pre>
 *
 * @see Cuenta
 * @see Concepto
 */
@Entity
@Table(name="creditos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credito implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the credit transaction.
     */
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    /**
     * The account associated with the credit transaction.
     */
    @ManyToOne
    @JoinColumn(name="id_cuenta")
    private Cuenta cuenta;

    /**
     * The concept associated with the credit transaction.
     */
    @ManyToOne
    @JoinColumn(name="id_concepto")
    private Concepto concepto;

    /**
     * The period of the credit transaction.
     */
    private Integer periodo;

    /**
     * The value of the credit transaction.
     */
    private BigDecimal valor;

    /**
     * The document ID associated with the credit transaction.
     */
    private UUID idDocumento;

    /**
     * The date and time when the transaction occurred.
     */
    private Instant fechaTransaccion;

    /**
     * The date and time when the record was registered.
     */
    private Instant fechaRegistro;

    /**
     * The user who last updated the record.
     */
    private String usuarioActualizacion;
	private BigDecimal duplicateValor() {
		return valor;
	}
}
/**
 * 
 */