package az.code.unisubscription.controllers;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.services.ISubscriptionService;
import az.code.unisubscription.utils.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
        private ISubscriptionService service;

        public SubscriptionController(ISubscriptionService service) {
            this.service = service;
        }

        /**
         * gets all students
         *
         * @return
         */
        @GetMapping
        public ResponseEntity<Pageable<SubscriptionGetDTO>> getStudents(
                @RequestParam(required = false, value = "size") Integer size,
                @RequestParam(required = false, defaultValue = "1") int page) {
            return new ResponseEntity<>(service.getAll(size, page), HttpStatus.OK);
        }
//        /**
//         * creates new student
//         * @param student
//         * @return
//         */
//        @PostMapping
//        public ResponseEntity<SubscriptionGetDTO> insertStudent(@RequestBody SubscriptionGetDTO subscription){
//            return new ResponseEntity<>(service.addStudent(student), HttpStatus.OK);
//        }
//
//        /**
//         * updates the student by id
//         * @param id
//         * @param student
//         * @return
//         */
//        @PutMapping("/{id}")
//        public ResponseEntity<StudentMarkDTO> updateStudent(@PathVariable int id , @RequestBody Student student){
//            StudentMarkDTO updatedStudent = service.updateStudent(id, student);
//            if (updatedStudent == null) throw new StudentNotFound();
//            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
//        }
//
//        /**
//         * deletes the student by id
//         * @param id
//         * @return
//         */
//        @DeleteMapping("/{id}")
//        public ResponseEntity deleteStudent(@PathVariable int id ){
//            if(service.deleteStudent(id) == null) throw new StudentNotFound();
//            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
//        }

}
