package com.foodparcel.Repository;
/**Yusrah Soeker
 * 218150768
 */
import com.foodparcel.entity.Donation;
import java.util.Set;

public interface DonationRepository extends IRepository <Donation, String> {
    Set<Donation> getAll();
}
