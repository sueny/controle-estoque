package projeto.engenharia.software.controle.estoque.base.entity.util;

/**
 *
 * @author Sueny
 */
public class Querys {

    public static final String SQL_PRODUTO_TOP_10 = "SELECT id, name, sum(total) as total FROM ("
            .concat("SELECT  i.id, i.name, sum(sp.QUANTITY) as total, sm.TYPE  FROM product as p ")
            .concat("inner join stock as s on p.id = s.product ")
            .concat("inner join stockmovementproduct as sp on s.id = sp.stock ")
            .concat("inner join stockmovement as sm on sp.stockMovement = sm.id ")
            .concat("inner join item as i on i.id = p.id ")
            .concat("where sm.TYPE = 'V' ")
            .concat("group by i.id ")
            .concat("union all ")
            .concat("SELECT i2.id, i2.name, sum(sp2.QUANTITYACERTO) as total, 'C' as TYPE  FROM product as p2 ")
            .concat("inner join stock as s2 on p2.id = s2.product ")
            .concat("inner join stockmovementadjustproduct as sp2 on s2.id = sp2.stock ")
            .concat("inner join stockmovementadjust as sm2 on sp2.stockMovementAdjust = sm2.id ")
            .concat("inner join item as i2 on i2.id = p2.id ")
            .concat("group by i2.id ")
            .concat(") consulta ")
            .concat("group by id ")
            .concat("order by total desc ")
            .concat("limit 10 ");
}
