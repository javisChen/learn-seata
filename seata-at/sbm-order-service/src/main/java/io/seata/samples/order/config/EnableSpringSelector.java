
package io.seata.samples.order.config;

import io.seata.samples.common.config.UserConfig;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;

import java.lang.annotation.*;

public class EnableSpringSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
            UserConfig.class.getName()
        } ;
    }
}
