package net.carProject.domain;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY)
    private List<Car> cars=new ArrayList<Car>();

    @OneToMany(mappedBy = "commentator",fetch = FetchType.LAZY)
    private List<Comment> comments=new ArrayList<Comment>();

    @OneToMany(mappedBy = "renter",fetch = FetchType.LAZY)
    private List<Transaction> transactions= new ArrayList<Transaction>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name="lastName")
    @NotNull
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "gender")
    private String gender;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name = "numberOfDoc")
    @NotNull
    private String numberOfDoc;

    public String getNumberOfDoc() {
        return numberOfDoc;
    }

    public void setNumberOfDoc(String numberOfDoc) {
        this.numberOfDoc = numberOfDoc;
    }

    @Column(name = "phone")
    private String phone;

    @Column(name="pointsUser")
    private int pointsUser;

    public void setPointsUser(int pointsUser) {
        this.pointsUser = pointsUser;
    }

    public int getPointsUser() {
        return pointsUser;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", roles=" + roles +
                ", cars=" + cars +
                ", comments=" + comments +
                ", transactions=" + transactions +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numberOfDoc='" + numberOfDoc + '\'' +
                ", phone='" + phone + '\'' +
                ", pointsUser='" + pointsUser + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id_user != user.id_user) return false;
        if (age != user.age) return false;
        if (pointsUser != user.pointsUser) return false;
        if (roles != null ? !roles.equals(user.roles) : user.roles != null) return false;
        if (cars != null ? !cars.equals(user.cars) : user.cars != null) return false;
        if (comments != null ? !comments.equals(user.comments) : user.comments != null) return false;
        if (transactions != null ? !transactions.equals(user.transactions) : user.transactions != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (numberOfDoc != null ? !numberOfDoc.equals(user.numberOfDoc) : user.numberOfDoc != null) return false;
        return phone != null ? phone.equals(user.phone) : user.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id_user;
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (cars != null ? cars.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (transactions != null ? transactions.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (numberOfDoc != null ? numberOfDoc.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + pointsUser;
        return result;
    }
}
