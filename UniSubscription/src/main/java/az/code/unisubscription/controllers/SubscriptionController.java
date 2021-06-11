package az.code.unisubscription.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    public class SubscriptionController {
        private IStudentService service;
        public StudentController(IStudentService service){
            this.service = service;
        }

        /**
         * gets all students
         * @return
         */
        @GetMapping
        public ResponseEntity<Pagination<StudentMarkDTO>> getStudents(HttpServletRequest request,
                                                                      @RequestParam(required = false, value = "size") Integer size,
                                                                      @RequestParam(required = false, defaultValue = "1") int page){
            return new ResponseEntity<>(service.getAll(size , page, request.getRequestURL().toString()), HttpStatus.OK);
        }

        /**
         * gets the student by id
         * @param id
         * @return
         */
        @GetMapping("/{id}")
        public ResponseEntity<StudentMarkDTO> getStudentById(@PathVariable int id) {
            StudentMarkDTO student = service.getStudent(id);
            if (student == null) {
                throw new StudentNotFound();
            }
            return new ResponseEntity<>(student, HttpStatus.OK);
        }

        /**
         * gets the students by given name and surname
         * @param name
         * @param surname
         * @return
         */
        @GetMapping("/find")
        public ResponseEntity<StudentMarkDTO> find(HttpServletRequest request,
                                                   @RequestParam(required = false, value = "size") Integer size,
                                                   @RequestParam(required = false, defaultValue = "1") int page,
                                                   @RequestParam String name,
                                                   @RequestParam String surname){
            return new ResponseEntity(service.find(size, page, request.getRequestURL().toString(), name, surname), HttpStatus.OK);
        }

        /**
         * creates new student
         * @param student
         * @return
         */
        @PostMapping
        public ResponseEntity<StudentMarkDTO> insertStudent(@RequestBody Student student){
            return new ResponseEntity<>(service.addStudent(student), HttpStatus.OK);
        }

        /**
         * updates the student by id
         * @param id
         * @param student
         * @return
         */
        @PutMapping("/{id}")
        public ResponseEntity<StudentMarkDTO> updateStudent(@PathVariable int id , @RequestBody Student student){
            StudentMarkDTO updatedStudent = service.updateStudent(id, student);
            if (updatedStudent == null) throw new StudentNotFound();
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }

        /**
         * deletes the student by id
         * @param id
         * @return
         */
        @DeleteMapping("/{id}")
        public ResponseEntity deleteStudent(@PathVariable int id ){
            if(service.deleteStudent(id) == null) throw new StudentNotFound();
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }

        /**
         * gets the first n students with highest grades
         * @param count
         * @return
         */
        @GetMapping("/highestgrades")
        public ResponseEntity<Pagination<StudentMarkDTO>> mostGradedStudents(@RequestParam int count,
                                                                             HttpServletRequest request,
                                                                             @RequestParam(required = false, value = "size") Integer size,
                                                                             @RequestParam(required = false, defaultValue = "1") int page
        ){
            return new ResponseEntity<>(service.mostGradedStudents(count, page, size, request.getRequestURL().toString()), HttpStatus.OK);
        }

        /**
         * gets the students with grades above the given grade
         * @param grade
         * @return
         */
        @GetMapping("/abovegivengrade")
        public ResponseEntity<Pagination<StudentMarkDTO>> aboveGivenGradeStudents(@RequestParam int grade,
                                                                                  HttpServletRequest request,
                                                                                  @RequestParam(required = false, value = "size") Integer size,
                                                                                  @RequestParam(required = false, defaultValue = "1") int page){
            return new ResponseEntity<>(service.aboveGivenGradeStudents(grade, page, size, request.getRequestURL().toString()), HttpStatus.OK);
        }

        /**
         * gets the students with 70 percent of their grades above 50
         * @return
         */
        @GetMapping("/abovefifty")
        public ResponseEntity<Pagination<StudentMarkDTO>> aboveFifty(HttpServletRequest request,
                                                                     @RequestParam(required = false, value = "size") Integer size,
                                                                     @RequestParam(required = false, defaultValue = "1") int page){
            return new ResponseEntity<>(service.aboveFiftyStudents(page, size, request.getRequestURL().toString()), HttpStatus.OK);
        }

        /**
         * gets students with name and grade
         * @return
         */
        @GetMapping("/findbynameandgrade")
        public ResponseEntity<Pagination<StudentMarkDTO>> findByNameAndGrade(HttpServletRequest request,
                                                                             @RequestParam String name,
                                                                             @RequestParam int grade,
                                                                             @RequestParam(required = false, value = "size") Integer size,
                                                                             @RequestParam(required = false, defaultValue = "1") int page){
            return new ResponseEntity<>(service.findStudentByNameAndGrade(name, grade,page, size, request.getRequestURL().toString()), HttpStatus.OK);
        }
}
