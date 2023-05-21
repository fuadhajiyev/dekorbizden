//package az.code.dekor_bizden.shared;
//
//
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import az.code.dekor_bizden.file.FileService;
//import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//public class FileTypeValidator implements ConstraintValidator<FileType, String> {
//
//    @Autowired
//    FileService fileService;
//
//    String[] types;
//
//    @Override
//    public void initialize(FileType constraintAnnotation) {
//        this.types = constraintAnnotation.types();
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        System.out.print("isValid=== " + value);
//
//        if (value == null || value.isEmpty()) {
//            return true;
//        }
//        String fileType = fileService.detectType(value);
//        for (String supportedType : this.types) {
//
//            if (fileType.contains(supportedType)) {
//                return true;
//            }
//        }
//
//        // prepared personal validation style
//        String supportedTypes = Arrays.stream(this.types).collect(Collectors.joining(", "));
//        context.disableDefaultConstraintViolation();
//        HibernateConstraintValidatorContext hibernateConstraintValidatorContext = context
//                .unwrap(HibernateConstraintValidatorContext.class);
//        hibernateConstraintValidatorContext.addMessageParameter("types", supportedTypes);
//        hibernateConstraintValidatorContext
//                .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
//                .addConstraintViolation();
//
//        return false;
//    }
//
//}