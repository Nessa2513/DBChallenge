SELECT * FROM challenge.employee;

# Punto 2
SELECT * FROM employee e 
INNER JOIN institution i ON e.idemployee = i.idEmployee;

#Punto 3
SELECT * FROM children
WHERE idEmployee IN(
	SELECT idEmployee FROM employee
    WHERE idCompany IN(
		SELECT idCompany FROM company
		WHERE coName = 'PriceSmart'
    )
);