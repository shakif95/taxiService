package dev.freenow.taxi.manufacturer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "manufacturers")
@NoArgsConstructor
@Getter
@Setter
public class Manufacturer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    public Long id;
    public String name;
}
