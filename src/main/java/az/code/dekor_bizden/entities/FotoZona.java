package az.code.dekor_bizden.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "foto_zona")
public class FotoZona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min = 5, max = 150)
    private String title;

    @NotNull
    @Size(min = 15, max=520)
    @Lob
    private String description;

    @NotNull
    private double price;

    @NotNull
    @Column(unique = true)
    private String itemCode;


//    private String type;
//    @NotNull
//    private int guest_count;

    private String  cover_img;

    private String  img_one;

    private String  img_two;

    private String  img_three;

    private String  img_four;






}
