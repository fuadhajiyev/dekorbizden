//package az.code.dekor_bizden.shared;
//
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.Target;
//
//import static java.lang.annotation.ElementType.FIELD;
//import static java.lang.annotation.RetentionPolicy.RUNTIME;
//
//@Target({ FIELD })
//@Retention(RUNTIME)
//@Constraint(validatedBy = { FileTypeValidator.class })
//public @interface CoverImage {
//
//    String message() default "{az.code.dekor_bizden.constraint.FileType.message}";
//
//    Class<?>[] groups() default {};
//
//    Class<? extends Payload>[] payload() default {};
//
//    String[] types();
//
//}