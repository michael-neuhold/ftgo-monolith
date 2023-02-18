package net.chrisrichardson.ftgo.courierservice.internal;


import com.google.common.collect.Lists;
import net.chrisrichardson.ftgo.common.Address;
import net.chrisrichardson.ftgo.common.PersonName;
import net.chrisrichardson.ftgo.courierservice.CourierService;
import net.chrisrichardson.ftgo.domain.Action;
import net.chrisrichardson.ftgo.domain.Courier;
import net.chrisrichardson.ftgo.domain.CourierRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("courier-service-internal")
public class CourierServiceInternalImpl implements CourierService {

  private CourierRepository courierRepository;

  public CourierServiceInternalImpl(CourierRepository courierRepository) {
    this.courierRepository = courierRepository;
  }

  @Transactional
  public void updateAvailability(long courierId, boolean available) {
    if (available)
      noteAvailable(courierId);
    else
      noteUnavailable(courierId);
  }

  @Transactional
  public Courier createCourier(PersonName name, Address address) {
    Courier courier = new Courier(name, address);
    courierRepository.save(courier);
    return courier;
  }

  void noteAvailable(long courierId) {
    courierRepository.findById(courierId).get().noteAvailable();
  }

  void noteUnavailable(long courierId) {
    courierRepository.findById(courierId).get().noteUnavailable();
  }

  public Optional<Courier> findCourierById(long courierId) {
    return courierRepository.findById(courierId);
  }

  @Override
  public List<Courier> findAll() {
    return Lists.newArrayList(courierRepository.findAll());
  }

  @Override
  public List<Courier> findAllAvailable() {
    return Lists.newArrayList(courierRepository.findAllAvailable());
  }

  @Override
  public void addAction(Courier courier, Action action) {
    courier.addAction(action);
  }

  @Override
  public void hello() {
    System.out.println("Hello from Consumer Service Internal");
  }

}
