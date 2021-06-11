package az.code.unisubscription.controllers;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.dto.SubscriptionPutDto;
import az.code.unisubscription.exceptions.SubscriptionNotFound;
import az.code.unisubscription.models.Subscription;
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
         * gets all subscriptions
         *
         * @return
         */
        @GetMapping
        public ResponseEntity<Pageable<SubscriptionGetDTO>> getStudents(
                @RequestParam(required = false, defaultValue = "10") Integer size,
                @RequestParam(required = false, defaultValue = "1") int page) {
            return new ResponseEntity<>(service.getAll(size, page), HttpStatus.OK);
        }
        /**
         * creates new subscription
         * @param subscription
         * @return
         */
        @PostMapping
        public ResponseEntity<SubscriptionGetDTO> insertStudent(@RequestBody SubscriptionPostDto subscription){
            return new ResponseEntity<>(service.addSubscription(subscription), HttpStatus.OK);
        }

        /**
         * updates the subscription by id
         * @param id
         * @param subscription
         * @return
         */
        @PutMapping("/{id}")
        public ResponseEntity<SubscriptionGetDTO> updateStudent(@PathVariable int id , @RequestBody SubscriptionPutDto subscription){
            SubscriptionGetDTO updatedStudent = service.updateSubscription(id, subscription);
            if (updatedStudent == null) throw new SubscriptionNotFound();
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        }

    /**
     * payment done
     * @param id
     * @param id
     * @return
     */
    @PutMapping("/{id}/donePayment")
    public ResponseEntity donePayment(@PathVariable int id){
        Subscription updatedStudent = service.doneMonthlyPayment(id);
        if (updatedStudent == null) throw new SubscriptionNotFound();
        return new ResponseEntity<>(HttpStatus.OK);
    }
        /**
         * deletes the student by id
         * @param id
         * @return
         */
        @DeleteMapping("/{id}")
        public ResponseEntity deleteStudent(@PathVariable int id ){
            if(service.deleteSubscription(id) == null) throw new SubscriptionNotFound();
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }

}
