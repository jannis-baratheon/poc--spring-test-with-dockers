package it.jwisniowski.example.springtestwithdockers.application.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("unused")
@Target({
    ElementType.METHOD,
    ElementType.FIELD,
    ElementType.ANNOTATION_TYPE,
    ElementType.CONSTRUCTOR,
    ElementType.PARAMETER,
    ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
@Constraint(validatedBy = {})
public @interface Hostname {
    String message() default "{it.jwisniowski.example.springtestwithdockers.application.validation.Hostname.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
