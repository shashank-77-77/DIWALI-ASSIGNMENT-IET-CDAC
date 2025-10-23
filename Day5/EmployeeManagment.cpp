// Write a Employee class with following properties:                        
//  - Member variables 
// o String empName 
// o int empID 
// o String empRole - Overloaded constructors 
// o No arguments constructor 
// o Constructor that accepts empId and empName (empRole is hardcoded) 
// o Constructor that accepts empID, empName and empRole - Override toString - Other methods of own choise 
// Write a menu driven program to demonstrate following operations using ArrayList of "Employee": 
// 1. Add Employee to list 
// 2. Remove Employee list 
// 3. Show all Employee 
// 4. Show all Employee in sorted order (sort on the basis of empID) 
// 5. Find a Employee with empName 
// 6. Save all Employees into file 
// 7. Quit

#include <iostream>
#include <vector>
#include <algorithm>
#include <fstream>
#include <sstream>
#include <string>
using namespace std;

class Employee {
private:
    int empID;
    string empName;
    string empRole;

public:
    // Default constructor
    Employee() : empID(0), empName("Unknown"), empRole("Not Assigned") {}

    // Constructor with ID and Name
    Employee(int id, string name) : empID(id), empName(name), empRole("Trainee") {}

    // Constructor with ID, Name, and Role
    Employee(int id, string name, string role) : empID(id), empName(name), empRole(role) {}

    // Getters
    int getID() const { return empID; }
    string getName() const { return empName; }
    string getRole() const { return empRole; }

    // toString equivalent
    string toString() const {
        return "ID: " + to_string(empID) + ", Name: " + empName + ", Role: " + empRole;
    }

    // Sorting comparator
    bool operator<(const Employee &other) const {
        return empID < other.empID;
    }
};

// Show main menu
void showMenu() {
    cout << "\n========= EMPLOYEE MANAGEMENT SYSTEM =========\n";
    cout << "1. Add Employee\n";
    cout << "2. Remove Employee\n";
    cout << "3. Show All Employees\n";
    cout << "4. Show All Employees (Sorted by ID)\n";
    cout << "5. Find Employee by Name\n";
    cout << "6. Save Employees to File\n";
    cout << "7. Quit\n";
    cout << "=============================================\n";
    cout << "Enter your choice: ";
}

// Add Employee
void addEmployee(vector<Employee> &empList) {
    int id;
    string name, role;
    int choice;
    cout << "Select Constructor Type:\n1. Default\n2. ID + Name\n3. ID + Name + Role\nChoice: ";
    cin >> choice;

    switch (choice) {
        case 1:
            empList.push_back(Employee());
            cout << "Employee added (default values).\n";
            break;
        case 2:
            cout << "Enter Employee ID: ";
            cin >> id;
            cout << "Enter Employee Name: ";
            cin.ignore();
            getline(cin, name);
            empList.push_back(Employee(id, name));
            cout << "Employee added with default role.\n";
            break;
        case 3:
            cout << "Enter Employee ID: ";
            cin >> id;
            cout << "Enter Employee Name: ";
            cin.ignore();
            getline(cin, name);
            cout << "Enter Employee Role: ";
            getline(cin, role);
            empList.push_back(Employee(id, name, role));
            cout << "Employee added successfully.\n";
            break;
        default:
            cout << "Invalid constructor choice.\n";
    }
}

// Remove Employee
void removeEmployee(vector<Employee> &empList) {
    int id;
    cout << "Enter Employee ID to remove: ";
    cin >> id;

    auto it = remove_if(empList.begin(), empList.end(),
                        [id](const Employee &emp) { return emp.getID() == id; });

    if (it != empList.end()) {
        empList.erase(it, empList.end());
        cout << "Employee removed successfully.\n";
    } else {
        cout << "Employee with given ID not found.\n";
    }
}

// Show all employees
void showAll(const vector<Employee> &empList) {
    if (empList.empty()) {
        cout << "No employees in the system.\n";
        return;
    }
    cout << "\n--- Employee List ---\n";
    for (const auto &emp : empList) {
        cout << emp.toString() << endl;
    }
}

// Show sorted employees
void showSorted(vector<Employee> empList) {
    sort(empList.begin(), empList.end());
    showAll(empList);
}

// Find Employee
void findEmployee(const vector<Employee> &empList) {
    string name;
    cout << "Enter Employee Name to search: ";
    cin.ignore();
    getline(cin, name);

    bool found = false;
    for (const auto &emp : empList) {
        if (emp.getName() == name) {
            cout << emp.toString() << endl;
            found = true;
        }
    }
    if (!found) cout << "Employee not found.\n";
}

// Save employees to file
void saveToFile(const vector<Employee> &empList) {
    ofstream file("employees.txt");
    if (!file) {
        cout << "Error: Unable to open file for saving.\n";
        return;
    }

    for (const auto &emp : empList) {
        file << emp.getID() << "," << emp.getName() << "," << emp.getRole() << "\n";
    }
    file.close();
    cout << "Employees saved to file successfully.\n";
}

// Load employees from file
void loadFromFile(vector<Employee> &empList) {
    ifstream file("employees.txt");
    if (!file) {
        cout << "No existing employee data found. Starting fresh.\n";
        return;
    }

    string line;
    while (getline(file, line)) {
        stringstream ss(line);
        string idStr, name, role;

        getline(ss, idStr, ',');
        getline(ss, name, ',');
        getline(ss, role, ',');

        if (!idStr.empty() && !name.empty() && !role.empty()) {
            int id = stoi(idStr);
            empList.push_back(Employee(id, name, role));
        }
    }

    file.close();
    cout << "Employee data loaded successfully from file.\n";
}

// Main driver
int main() {
    vector<Employee> empList;
    loadFromFile(empList); // Load existing employees from file at startup
    int choice;

    while (true) {
        showMenu();
        cin >> choice;

        switch (choice) {
            case 1: addEmployee(empList); break;
            case 2: removeEmployee(empList); break;
            case 3: showAll(empList); break;
            case 4: showSorted(empList); break;
            case 5: findEmployee(empList); break;
            case 6: saveToFile(empList); break;
            case 7:
                cout << "Saving data and exiting system...\n";
                saveToFile(empList);
                cout << "Goodbye!\n";
                return 0;
            default:
                cout << "Invalid option. Please re-enter.\n";
        }
    }
}
