
package infrastructure.in;

import java.util.Scanner;

import application.CreateUserUseCase;
import application.DeleteUserUseCase;
import application.FindUserUseCase;
import application.UpdateUserUseCase;
import domain.entity.User;

public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final FindUserUseCase findUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase, FindUserUseCase findUserUseCase, DeleteUserUseCase deleteUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void createUSer() {


        System.out.println("Enter user name: ");
        String name = scanner.nextLine();
        
        System.out.println("Enter user email: ");
        String email = scanner.nextLine();
        
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        
        createUserUseCase.execute(user);
        System.out.println("User created successfully!");
        
    }
    
    public void deleteUser(){

        System.out.println("Enter the user id to delete it");
        Long deleteUser = scanner.nextLong();
        scanner.nextLine();

        // User userD = new User();
        deleteUserUseCase.execute(deleteUser);

        if(deleteUserUseCase != null){
            System.out.println("Eliminado");
        }else{
            System.out.println("No eliminado");
        }

    }

    public void findUser(){

        System.out.println("Enter the id to find the user: ");
        Long findId = scanner.nextLong();
        scanner.nextLine();

        User foundUser = findUserUseCase.execute(findId);

        if (foundUser != null) {
            System.out.println("User Id: " + foundUser.getId());
            System.out.println("User name: " + foundUser.getName());
            System.out.println("User email: " + foundUser.getEmail());
        }else{
            System.out.println("User not found");
        }

    }

    public void updateUser(){
 
        System.out.println("Enter the id to update user: ");
        Long idUpdate = scanner.nextLong();
        scanner.nextLine();

        
        System.out.println("Enter new user name: ");
        String newName = scanner.nextLine();
        
        System.out.println("Enter new email: ");
        String newEmail = scanner.nextLine();
        
        User newUser = new User();
        newUser.setId(idUpdate);
        newUser.setName(newName);
        newUser.setEmail(newEmail);


        
        if (updateUserUseCase != null) {
            updateUserUseCase.execute(newUser);
        } else {
            System.out.println("updateUserUseCase no está inicializado correctamente");
        }

    }
    
}
