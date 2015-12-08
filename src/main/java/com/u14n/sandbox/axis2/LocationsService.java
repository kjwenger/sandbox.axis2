package com.u14n.sandbox.axis2;

import com.u14n.sandbox.model.geography.LocationDAO;
import com.u14n.sandbox.model.geography.Location;
import com.u14n.sandbox.model.DAOException;

import java.util.List;

public class LocationsService {

	private LocationDAO locationDAO = new LocationDAO.ConcurrentMemory();

	public LocationsService() {
		try {
			this.locationDAO.insert(new Location(
					"USA",
					"NC",
					"27601",
					"Raleigh",
					"S McDowell St",
					"500"));
			this.locationDAO.insert(new Location(
					"USA",
					"NC",
					"27601",
					"Raleigh",
					"E Davie Street",
					"100"));
		} catch (DAOException e) {
			// Ignore
		}
	}

	public Location findByIdentity(int id) throws DAOException {
																				System.out.println("LocationsService.findByIdentity() id=" + id);
		Location location = this.locationDAO.findByIdentity(id);
																				System.out.println("LocationsService.findByIdentity() location=" + location);
		return location;
	}

	public List<Location> findByName(String name) throws DAOException {
																				System.out.println("LocationsService.findByName() name=" + name);
		List<Location> list = this.locationDAO.findAll(); // this.locationDAO.findByName(name);
																				System.out.println("LocationsService.findByName() list.size()=" + list.size());
		return list;
	}

	public List<Location> findAll() throws DAOException {
		List<Location> list = this.locationDAO.findAll();
																				System.out.println("LocationsService.findAll() list.size()=" + list.size());
		return list;
	}

}
