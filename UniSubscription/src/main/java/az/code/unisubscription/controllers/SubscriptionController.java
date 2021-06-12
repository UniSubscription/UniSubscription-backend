package az.code.unisubscription.controllers;

import az.code.unisubscription.dto.SubscriptionGetDTO;
import az.code.unisubscription.dto.SubscriptionPostDto;
import az.code.unisubscription.dto.SubscriptionPutDto;
import az.code.unisubscription.exceptions.SubscriptionNotFound;
import az.code.unisubscription.models.Subscription;
import az.code.unisubscription.models.User;
import az.code.unisubscription.services.ISubscriptionService;
import az.code.unisubscription.utils.JwtTokenUtil;
import az.code.unisubscription.utils.Pageable;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
        public ResponseEntity<Pageable<SubscriptionGetDTO>> getAll(
                HttpServletRequest request,
                @RequestParam(required = false, defaultValue = "10") Integer size,
                @RequestParam(required = false, defaultValue = "1") int page) throws BadHttpRequest {

            User user = jwtTokenUtil.getUserFromToken(request.getHeader("Authorization").replace("Bearer ", ""));
            if (user == null){
                throw new BadHttpRequest();
            }
            return new ResponseEntity<>(service.getAll(user.getId(), size, page), HttpStatus.OK);
        }

    /**
     * gets all subscriptions
     *
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionGetDTO> getById(
            HttpServletRequest request,
            @PathVariable int id) throws BadHttpRequest {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

        /**
         * creates new subscription
         * @param subscription
         * @return
         */
        @PostMapping
        public ResponseEntity<SubscriptionGetDTO> insertStudent(
                HttpServletRequest request,
                @RequestBody SubscriptionPostDto subscription) throws BadHttpRequest {
            User user = jwtTokenUtil.getUserFromToken(request.getHeader("Authorization").replace("Bearer ", ""));
            if (user == null){
                throw new BadHttpRequest();
            }
            return new ResponseEntity<>(service.addSubscription(user.getId(), subscription), HttpStatus.OK);
        }

        /**
         * updates the subscription by id
         * @param id
         * @param subscription
         * @return
         */
        @PostMapping("/{id}")
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
    @GetMapping("/{id}/donePayment")
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
