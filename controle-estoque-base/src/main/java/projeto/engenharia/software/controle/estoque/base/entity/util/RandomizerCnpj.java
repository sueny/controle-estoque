/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.engenharia.software.controle.estoque.base.entity.util;

import com.mifmif.common.regex.Generex;
import io.github.benas.randombeans.api.Randomizer;

/**
 *
 * @author Sueny
 */
public class RandomizerCnpj implements Randomizer<String> {

    @Override
    public String getRandomValue() {
        Generex generex = new Generex("\\d{14}");
        // generate the second String in lexicographical order that match the given Regex.
        String string = generex.getMatchedString(2);
        return string;
    }

}
