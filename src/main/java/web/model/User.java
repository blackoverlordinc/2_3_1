package web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    @Column(name = "name", nullable = false, length = 50) //сюда добавил аннотации для валидации
    @NotEmpty(message = "Your name should not be empty")
    @Size(min = 2, max = 50, message = "Your name should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Za-z]+", message = "your name can only contain lowercase and uppercase letters")
    private String name;
    @Column(name = "surname", nullable = false, length = 50) //сюда добавил аннотации для валидации
    @NotEmpty(message = "Your surname should not be empty")
    @Size(min = 2, max = 50, message = "Your surname should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Za-z]+", message = "your surname can only contain lowercase and uppercase letters")
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
