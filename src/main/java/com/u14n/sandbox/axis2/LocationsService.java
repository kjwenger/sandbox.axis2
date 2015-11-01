package com.u14n.sandbox.axis2;

import com.u14n.sandbox.model.LocationDAO;
import com.u14n.sandbox.model.Location;
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
				"500 S McDowell St"));
			this.locationDAO.insert(new Location(
					"USA",
					"NC",
					"27601",
					"Raleigh",
					"100 E Davie Street"));
		} catch (DAOException e) {
			// Ignore
		}
	}

	public Location findById(int id) throws DAOException {
		/* trace */ System.out.println("LocationsService.findById() id=" + id);
		Location location = this.locationDAO.findById(id);
		/* trace */ System.out.println("LocationsService.findById() location=" + location);
		return location;
	}

	public List<Location> findByName(String name) throws DAOException {
		/* trace */ System.out.println("LocationsService.findByName() name=" + name);
		List<Location> list = this.locationDAO.findAll(); // this.locationDAO.findByName(name);
		/* trace */ System.out.println("LocationsService.findByName() list.size()=" + list.size());
		return list;
	}

	public List<Location> findAll() throws DAOException {
		List<Location> list = this.locationDAO.findAll();
		/* trace */ System.out.println("LocationsService.findAll() list.size()=" + list.size());
		return list;
	}

}
