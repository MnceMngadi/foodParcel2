package com.foodparcel.Repository;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.entity.Donor;
import java.util.Set;

public interface DonorRepository extends IRepository <Donor, String> {
    Set<Donor> getAll();
}