class Employee {
    String empId;
    double salary;

    Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary; // using this.salary to resolve clash
    }

    void raiseSalary(double salary) {
        this.salary += salary; // resolve clash with parameter
    }

    void printFinalSalary() {
        System.out.println(empId + " | Final Salary: Rs " + this.salary);
    }

    public static void main(String[] args) {
        Employee[] team = {
            new Employee("E-101", 40000),
            new Employee("E-102", 55000),
            new Employee("E-103", 62000),
            new Employee("E-104", 48000)
        };

        for (Employee e : team) {
            e.raiseSalary(5000);
            e.printFinalSalary();
        }
    }
}
