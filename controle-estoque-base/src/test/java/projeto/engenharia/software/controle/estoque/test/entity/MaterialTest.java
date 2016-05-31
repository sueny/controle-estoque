package projeto.engenharia.software.controle.estoque.test.entity;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Assert;
import org.junit.Test;
import projeto.engenharia.software.controle.estoque.base.entity.Material;

/**
 *
 * @author House
 */
public class MaterialTest {

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(MaterialTest.class);
    }

    @Test
    public void testeMaterialNotNull() {
        EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build();
        Material material = enhancedRandom.nextObject(Material.class);
        
        Assert.assertNotNull(material);
    }
    
    @Test
    public void testeMaterialNull() {
        Material material = null;
        Assert.assertNull(material);
    }
}
