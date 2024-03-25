# PawShelter

#### Curso Escolar 2023-2024
#### Autor: [Jorge Vázquez Espinosa](https://github.com/Jvazesp2002)
#### Tutor: [Antonio Gabriel González Casado](https://github.com/antonio-gabriel-gonzalez-casado)
#### Fecha de Inicio: 25-03-2024
#### Fecha de Finalización: TBD

## Breve descripción del proyecto

El proyecto consiste en unir las funciones de una protectora de animales y de una guardería para mascotas, pudiendo tanto añadir mascotas a la lista de adopcion como brindar a los dueños de mascotas la posibilidad de dejarlas en la guarderia durante un tiempo en el que ellos no puedan cuidarlas.

## Definir el objetivo de la aplicación
La aplicación permitirá a los usuarios registrarse y acceder a un entorno donde podrán buscar mascotas disponibles para adopción. Cada perfil de mascota incluirá detalles, como especie, edad, género, para que los usuarios puedan encontrar la mascota que mejor se adapte a sus preferencias. Además, la plataforma incorporará funcionalidades de búsqueda avanzada para permitir a los usuarios filtrar las mascotas disponibles según criterios específicos, como especie y edad.

Tambien, como se mencionó en la descripción la applicación permitirá a dueños de mascotas rellenar un breve formulario con sus datos y los de su mascota, para que durante un breve tiempo, esta reciba cuidados en la guarderia mientras que el dueño no puede cuidarla. PawShelter, ademas de aunar las funciones de un refugio de animales y de una guardería, permitirá a las personas con menos capacidad económica dejar derante un periodo de dos semanas como máximo a su mascota a coste cero, ya que, mediante un voluntariado al que las personas podran optar a hacer, podrán desempeñar la labor de cuidar a los animales de la guardería.

## Estructura del Proyecto

- src-api
- src-frontend
- docs
- README.md

En src-api, se encontrará la parte backend de la applicación con la logica de negocio, que generará automaticamente con el inicio de la aplicación un listado con 50 animales que se encontrarán algunos en el listado de adopción y otros en el listado de la guardería y algunos dueños y voluntarios que serán asignados a las mascotas en la guardería.

En src-frontend, se encontrará el apartado visual de la aplicacion, donde mediante Angular, HTML, SCSS y Bootstrap, se generará una página de uso simple que consumira el backend a la hora de la autenticacion de usuarios, buscando en la base de datos si es un usuario registrado , voluntario o el mismo dueño. Tendrá distintos apartados como el listado de mascotas disponibles para adopción con algunos detalles de la misma. Un listado de las mascotas que están en la guarderia donde los voluntarios podrán acceder para darle cuidados a las mismas y se verán los detalles de estas como el nombre del dueño, el periodo durante el cual estará en la guarderia y el voluntario asignado, que este ultimo, será asignado a traves del rol del administrador. Por ultimo, tendrá el panel de control administrativo, en el cual el administrador podrá gestionar los usuarios dados de alta, los voluntarios y podrá acceder a los listados para hacer cambios en ellos, como quitar del listado la mascota porque ya haya sido adoptada o su periodo en la guarderia haya acabado y añadir voluntarios a las mascotas en la guardería.
