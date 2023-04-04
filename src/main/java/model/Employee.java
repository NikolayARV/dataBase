package model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode (exclude = {"id"})
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String first_name;
    @Column(name = "last_name", length = 50, nullable = false)
    private String last_name;
    @Column(name = "gender", length = 50, nullable = false)
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "city_id")
    private int city;


}
