package com.example.FirstSpring.entity;

//import jakarta.persistence.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_city")
    private String employeeCity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employees_projects",
    joinColumns = @JoinColumn(name = "fk_employee"),
    inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private List<Project> projects;


    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Employee(String employeeName, String employeeCity) {
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int id) {
        this.employeeId = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void removeProject(Project project){
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project){
        this.projects.add(project);
        project.getEmployees().add(this);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addAddress(Address address){
        this.address = new ArrayList<>();
        this.address.add(address);
        address.setEmployee(this);
    }

    public void removeAddress(Address address){
        this.address.remove(address);
        address.setEmployee(null);
    }
}
