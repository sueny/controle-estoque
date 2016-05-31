package projeto.engenharia.software.controle.estoque.test.entity;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Assert;
import org.junit.Test;
import projeto.engenharia.software.controle.estoque.base.entity.Material;
import projeto.engenharia.software.controle.estoque.base.entity.Supplier;

/**
 *
 * @author House
 */
public class SupplierTest {

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(SupplierTest.class);
    }

    @Test
    public void testeMaterialNotNull() {
        EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
        Supplier s = enhancedRandom.nextObject(Supplier.class);
        
        Assert.assertNotNull(s);
    }
    
    @Test
    public void testeMaterialNull() {
        Supplier s = null;
        Assert.assertNull(s);
    }
}
