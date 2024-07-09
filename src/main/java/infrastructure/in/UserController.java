
package infrastructure.in;

import java.util.Scanner;

import application.CreateUserUseCase;
import application.UpdateUserUseCase;
import domain.entity.User;

public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }



    public void start() {

        while(true){
   

            try (Scanner scanner = new Scanner(System.in)) {

                while(true){

                    System.out.println("-----BASE DE DATOS-----");
                    System.out.println("1. Crear Usuario: ");
                    System.out.println("2. Actualizar Usuario:  ");
                    System.out.println(3);


                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
            
                            System.out.println("Enter user name: ");
                            String name = scanner.nextLine();
                            
                            System.out.println("Enter user email: ");
                            String email = scanner.nextLine();
                            
                            User user = new User();
                            user.setName(name);
                            user.setEmail(email);
                            
                            createUserUseCase.execute(user);
                            System.out.println("User created successfully!");
                            
                            break;

                        case 2:
                        
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

                            break;

                        
                        case 3:

                            


                        default:
                            throw new AssertionError();
                    }
                }

            }
        }

    }
}
