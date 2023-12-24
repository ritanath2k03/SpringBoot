package com.springsql.crudsql.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// import com.springsql.Service.StudentService;


@RestController
public class Welcome<Student> {
    
        @GetMapping("/welcome")
        public static String getWelcome(){
            return "Welcome Guys";
        }

        // @Autowired
        // StudentService service;

      
    
        // /**
        //  * @param student
        //  */
        // @PostMapping("/add-data")
        // public void addStudent(@RequestBody Student student){
        //     System.out.println(student);
        //     service.addStudent((com.springsql.Model.Student) student);
            
        // }
        
}
