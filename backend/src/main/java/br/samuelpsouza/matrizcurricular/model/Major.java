package br.samuelpsouza.matrizcurricular.model;

import br.samuelpsouza.matrizcurricular.util.Period;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Column(unique = true)
    private String code;
    @NotNull
    @NotBlank
    @NotEmpty
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private Period period;
    private String duration;
    private String registrationNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Matrix matrix = new Matrix();

    public Major(@NotNull @NotBlank @NotEmpty String code, @NotNull @NotBlank @NotEmpty String title) {
        this.code = code;
        this.title = title;
    }

    public Major(@NotNull @NotBlank @NotEmpty String code, @NotNull @NotBlank @NotEmpty String title, String description, Period period, String duration, String registrationNumber, Matrix matrix) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.period = period;
        this.duration = duration;
        this.registrationNumber = registrationNumber;
        this.matrix = matrix;
    }
}
