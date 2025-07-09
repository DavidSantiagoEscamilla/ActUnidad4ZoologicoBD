package com.davidsantiagoact2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ConsultorDeScript {

    public void mostrarNombreDescripcionTodasLasEspecies() {
        String sql = "SELECT nombre_comun, descripcion FROM Especie";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("--- Nombre y Descripción de Todas las Especies ---");
            while (rs.next()) {
                String nombreComun = rs.getString("nombre_comun");
                String descripcion = rs.getString("descripcion");
                System.out.println("Especie: " + nombreComun + ", Descripción: " + descripcion);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombre y descripción de especies: " + e.getMessage());
        }
    }

    public void consultarNombreCientificoEspeciesHabitatTropical() {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.clima = 'Tropical'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Nombres Científicos en Hábitat Tropical ---");
            while (rs.next()) {
                System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres científicos en hábitat tropical: " + e.getMessage());
        }
    }

    public void listarNombresHabitatsConClimaTipoVegetacion() {
        String sql = "SELECT nombre, clima, tipo_vegetacion FROM Habitat";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Detalles de Hábitats ---");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String clima = rs.getString("clima");
                String tipoVegetacion = rs.getString("tipo_vegetacion");
                System.out.println("Hábitat: " + nombre + ", Clima: " + clima + ", Vegetación: " + tipoVegetacion);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar detalles de hábitats: " + e.getMessage());
        }
    }

    public void obtenerExtensionCadaZona() {
        String sql = "SELECT nombre, extension FROM Zona";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Extensión de Cada Zona ---");
            while (rs.next()) {
                System.out.println("Zona: " + rs.getString("nombre") + ", Extensión: " + rs.getDouble("extension") + " m²");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener extensión de zonas: " + e.getMessage());
        }
    }

    public void mostrarCodigoDuracionTodosItinerarios() {
        String sql = "SELECT id_itinerario, duracion_minutos FROM Itinerario";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Código y Duración de Itinerarios ---");
            while (rs.next()) {
                int id = rs.getInt("id_itinerario");
                int duracion = rs.getInt("duracion_minutos");
                System.out.println("Itinerario ID: " + id + ", Duración: " + duracion + " minutos");
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar código y duración de itinerarios: " + e.getMessage());
        }
    }

    public void consultarNumeroMaxVisitantesCadaItinerario() {
        String sql = "SELECT id_itinerario, nombre, max_visitantes FROM Itinerario";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Máximo de Visitantes por Itinerario ---");
            while (rs.next()) {
                System.out.println("Itinerario ID: " + rs.getInt("id_itinerario") +
                                   ", Nombre: " + rs.getString("nombre") +
                                   ", Máx. Visitantes: " + rs.getInt("max_visitantes"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar máximo de visitantes por itinerario: " + e.getMessage());
        }
    }

    public void listarNombresContactoTodosLosGuias() {
        String sql = "SELECT nombre, contacto FROM Guia";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Nombres e Información de Contacto de Guías ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre") + ", Contacto: " + rs.getString("contacto"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar información de contacto de guías: " + e.getMessage());
        }
    }

    public void obtenerNombresDireccionesCuidadores() {
        String sql = "SELECT nombre, direccion FROM PersonalCuidador";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Nombres y Direcciones de Cuidadores ---");
            while (rs.next()) {
                System.out.println("Cuidador: " + rs.getString("nombre") + ", Dirección: " + rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener nombres y direcciones de cuidadores: " + e.getMessage());
        }
    }

    public void mostrarFechaInicioCadaGuia() {
        String sql = "SELECT nombre, fecha_inicio FROM Guia";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Fecha de Inicio de Guías ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre") + ", Fecha de Inicio: " + rs.getDate("fecha_inicio"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar fecha de inicio de guías: " + e.getMessage());
        }
    }

    public void consultarNombreDescripcionEspeciesHabitatAcuatico() {
        String sql = "SELECT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.nombre = 'Acuático'";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Especies en Hábitat Acuático ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar especies en hábitat acuático: " + e.getMessage());
        }
    }

    public void listarNombresCientificosEspeciesHabitatSelva() {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.nombre = 'Selva'";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Nombres Científicos en Hábitat de la Selva ---");
            while (rs.next()) {
                System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres científicos en hábitat de la selva: " + e.getMessage());
        }
    }

    public void obtenerNombreEspeciesZonasClimaTropical() {
        String sql = "SELECT DISTINCT E.nombre_comun FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "JOIN Zona Z ON H.id_zona = Z.id_zona " +
                     "WHERE H.clima = 'Tropical'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Especies en Zonas con Clima Tropical ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener especies en zonas con clima tropical: " + e.getMessage());
        }
    }

    public void mostrarNombreExtensionTodasLasZonas() {
        obtenerExtensionCadaZona();
    }

    public void consultarCodigoLongitudItinerariosMayorDosHoras() {
        String sql = "SELECT id_itinerario, longitud FROM Itinerario WHERE duracion_minutos > 120";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Itinerarios de Más de Dos Horas ---");
            while (rs.next()) {
                System.out.println("Itinerario ID: " + rs.getInt("id_itinerario") + ", Longitud: " + rs.getDouble("longitud"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar itinerarios de más de dos horas: " + e.getMessage());
        }
    }

    public void listarNombresGuiasLideranMasUnItinerario() {
        String sql = "SELECT G.nombre FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "GROUP BY G.nombre HAVING COUNT(I.id_itinerario) > 1";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Guías con Múltiples Itinerarios ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar guías con múltiples itinerarios: " + e.getMessage());
        }
    }

    public void obtenerFechaIngresoTodosCuidadores() {
        String sql = "SELECT nombre, fecha_ingreso FROM PersonalCuidador";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Fecha de Ingreso de Cuidadores ---");
            while (rs.next()) {
                System.out.println("Cuidador: " + rs.getString("nombre") + ", Fecha de Ingreso: " + rs.getDate("fecha_ingreso"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener fecha de ingreso de cuidadores: " + e.getMessage());
        }
    }

    public void mostrarInformacionContactoGuiasItinerarioMasLargo() {
        String sql = "SELECT G.nombre, G.contacto FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.duracion_minutos = (SELECT MAX(duracion_minutos) FROM Itinerario)";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Contacto de Guías del Itinerario Más Largo ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre") + ", Contacto: " + rs.getString("contacto"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar contacto de guías del itinerario más largo: " + e.getMessage());
        }
    }

    public void consultarNumeroEspeciesVisitadasCadaItinerario() {
        String sql = "SELECT I.nombre AS itinerario_nombre, COUNT(DISTINCT EH.id_especie) AS num_especies " +
                     "FROM Itinerario I " +
                     "JOIN Itinerario_Zona IZ ON I.id_itinerario = IZ.id_itinerario " +
                     "JOIN Zona Z ON IZ.id_zona = Z.id_zona " +
                     "JOIN Habitat H ON Z.id_zona = H.id_zona " +
                     "JOIN Especie_Habitat EH ON H.id_habitat = EH.id_habitat " +
                     "GROUP BY I.id_itinerario, I.nombre";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Número de Especies Visitadas por Itinerario ---");
            while (rs.next()) {
                System.out.println("Itinerario: " + rs.getString("itinerario_nombre") + ", Número de Especies: " + rs.getInt("num_especies"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar número de especies por itinerario: " + e.getMessage());
        }
    }

    public void listarNombreCientificoEspeciesAtendidasPorCuidador(String nombreCuidador) {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Animal A ON E.id_especie = A.id_especie " +
                     "JOIN PersonalCuidador PC ON A.id_personalcuidador = PC.id_cuidador " +
                     "WHERE PC.nombre = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreCuidador);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Especies Atendidas por " + nombreCuidador + " ---");
                while (rs.next()) {
                    System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar especies atendidas por cuidador: " + e.getMessage());
        }
    }

    public void obtenerNombreHabitatsVegetacionBosque() {
        String sql = "SELECT nombre FROM Habitat WHERE tipo_vegetacion = 'Bosque'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Hábitats con Vegetación Predominante de Bosque ---");
            while (rs.next()) {
                System.out.println("Hábitat: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener hábitats con vegetación de bosque: " + e.getMessage());
        }
    }

    public void mostrarDescripcionEspeciesZonasClimaTemplado() {
        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "JOIN Zona Z ON H.id_zona = Z.id_zona " +
                     "WHERE H.clima = 'Templado'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Especies en Zonas con Clima Templado ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar descripción de especies en zonas con clima templado: " + e.getMessage());
        }
    }

    public void consultarCodigoItinerarioMaxVisitantes() {
        consultarNumeroMaxVisitantesCadaItinerario();
    }

    public void listarNombresGuiasAsignadosItinerario(String nombreItinerario) {
        String sql = "SELECT G.nombre FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.nombre = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreItinerario);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Guías Asignados al Itinerario '" + nombreItinerario + "' ---");
                while (rs.next()) {
                    System.out.println("Guía: " + rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar guías para itinerario específico: " + e.getMessage());
        }
    }

    public void obtenerFechaInicioGuiasItinerariosCortos() {
        String sql = "SELECT DISTINCT G.nombre, G.fecha_inicio FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.duracion_minutos < 60";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Fecha de Inicio de Guías de Itinerarios Cortos ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre") + ", Fecha de Inicio: " + rs.getDate("fecha_inicio"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener fecha de inicio de guías de itinerarios cortos: " + e.getMessage());
        }
    }

    public void mostrarNombreDescripcionEspeciesAtendidasPorCuidadorParticular(String nombreCuidador) {
        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Animal A ON E.id_especie = A.id_especie " +
                     "JOIN PersonalCuidador PC ON A.id_personalcuidador = PC.id_cuidador " +
                     "WHERE PC.nombre = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreCuidador);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Especies Atendidas por " + nombreCuidador + " (Detalle) ---");
                while (rs.next()) {
                    System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar especies atendidas por cuidador particular: " + e.getMessage());
        }
    }

    public void consultarNombreCientificoEspeciesHabitatSabana() {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.nombre = 'Sabana'";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Nombres Científicos en Hábitat de la Sabana ---");
            while (rs.next()) {
                System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres científicos en hábitat de la sabana: " + e.getMessage());
        }
    }

    public void listarHabitatsClimaTropicalTipoVegetacionSelva() {
        String sql = "SELECT nombre FROM Habitat WHERE clima = 'Tropical' AND tipo_vegetacion = 'Selva'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Hábitats Tropicales de Selva ---");
            while (rs.next()) {
                System.out.println("Hábitat: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar hábitats tropicales de selva: " + e.getMessage());
        }
    }

    public void obtenerNombreEspeciesZonasExtensionSuperior(double areaMetrosCuadrados) {
        String sql = "SELECT DISTINCT E.nombre_comun FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "JOIN Zona Z ON H.id_zona = Z.id_zona " +
                     "WHERE Z.extension > ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, areaMetrosCuadrados);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Especies en Zonas con Extensión Mayor a " + areaMetrosCuadrados + " m² ---");
                while (rs.next()) {
                    System.out.println("Especie: " + rs.getString("nombre_comun"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener especies en zonas grandes: " + e.getMessage());
        }
    }

    public void mostrarExtensionZonaEspecieParticular(String nombreComunEspecie) {
        String sql = "SELECT DISTINCT Z.nombre AS zona_nombre, Z.extension FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "JOIN Zona Z ON H.id_zona = Z.id_zona " +
                     "WHERE E.nombre_comun = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreComunEspecie);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Extensión de Zona para Especie: " + nombreComunEspecie + " ---");
                if (rs.next()) {
                    System.out.println("Zona: " + rs.getString("zona_nombre") + ", Extensión: " + rs.getDouble("extension") + " m²");
                } else {
                    System.out.println("Especie '" + nombreComunEspecie + "' no encontrada o no asignada a una zona.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar extensión de zona para especie: " + e.getMessage());
        }
    }

    public void consultarNumeroItinerariosAtraviesanZona(String nombreZona) {
        String sql = "SELECT COUNT(DISTINCT I.id_itinerario) AS num_itinerarios FROM Itinerario I " +
                     "JOIN Itinerario_Zona IZ ON I.id_itinerario = IZ.id_itinerario " +
                     "JOIN Zona Z ON IZ.id_zona = Z.id_zona " +
                     "WHERE Z.nombre = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreZona);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Número de Itinerarios que Atraviesan la Zona '" + nombreZona + "' ---");
                if (rs.next()) {
                    System.out.println("Número de Itinerarios: " + rs.getInt("num_itinerarios"));
                } else {
                    System.out.println("Zona '" + nombreZona + "' no encontrada o sin itinerarios asociados.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar número de itinerarios por zona: " + e.getMessage());
        }
    }

    public void listarNombresGuiasItinerariosMayorTresHoras() {
        String sql = "SELECT DISTINCT G.nombre FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.duracion_minutos > 180";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Guías de Itinerarios de Más de Tres Horas ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar guías de itinerarios largos: " + e.getMessage());
        }
    }

    public void obtenerFechaIngresoCuidadoresAsignadosEspecie(String nombreComunEspecie) {
        String sql = "SELECT DISTINCT PC.nombre, PC.fecha_ingreso FROM PersonalCuidador PC " +
                     "JOIN Animal A ON PC.id_cuidador = A.id_personalcuidador " +
                     "JOIN Especie E ON A.id_especie = E.id_especie " +
                     "WHERE E.nombre_comun = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreComunEspecie);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Fecha de Ingreso de Cuidadores para Especie: " + nombreComunEspecie + " ---");
                while (rs.next()) {
                    System.out.println("Cuidador: " + rs.getString("nombre") + ", Fecha de Ingreso: " + rs.getDate("fecha_ingreso"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener fecha de ingreso de cuidadores para especie: " + e.getMessage());
        }
    }

    public void mostrarEspeciesAtendidasPorCuidadorIngresoMasCincoAnios() {
        LocalDate cincoAniosAtras = LocalDate.now().minus(5, ChronoUnit.YEARS);
        java.sql.Date sqlCincoAniosAtras = java.sql.Date.valueOf(cincoAniosAtras);

        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Animal A ON E.id_especie = A.id_especie " +
                     "JOIN PersonalCuidador PC ON A.id_personalcuidador = PC.id_cuidador " +
                     "WHERE PC.fecha_ingreso < ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, sqlCincoAniosAtras);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Especies Atendidas por Cuidadores con Más de 5 Años de Servicio ---");
                while (rs.next()) {
                    System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar especies por cuidador con más de 5 años: " + e.getMessage());
        }
    }

    public void consultarNombreCientificoEspeciesHabitatTempladoPradera() {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.clima = 'Templado' AND H.tipo_vegetacion = 'Pradera'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Nombres Científicos en Hábitat Templado de Pradera ---");
            while (rs.next()) {
                System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres científicos en hábitat templado de pradera: " + e.getMessage());
        }
    }

    public void listarHabitatsExtensionSuperior(double areaMetrosCuadrados) {
        String sql = "SELECT nombre FROM Habitat WHERE extension > ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, areaMetrosCuadrados);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Hábitats con Extensión Superior a " + areaMetrosCuadrados + " m² ---");
                while (rs.next()) {
                    System.out.println("Hábitat: " + rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar hábitats con extensión superior: " + e.getMessage());
        }
    }

    public void obtenerNombreEspeciesZonasMasCincoEspecies() {
        String sql = "SELECT DISTINCT E.nombre_comun FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "JOIN Zona Z ON H.id_zona = Z.id_zona " +
                     "WHERE Z.id_zona IN (SELECT Z2.id_zona FROM Zona Z2 " +
                     "JOIN Habitat H2 ON Z2.id_zona = H2.id_zona " +
                     "JOIN Especie_Habitat EH2 ON H2.id_habitat = EH2.id_habitat " +
                     "GROUP BY Z2.id_zona HAVING COUNT(DISTINCT EH2.id_especie) > 5)";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Especies en Zonas con Más de Cinco Especies Diferentes ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener especies en zonas con más de cinco especies: " + e.getMessage());
        }
    }

    public void mostrarDescripcionEspeciesHabitatTropicalBosque() {
        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.clima = 'Tropical' AND H.tipo_vegetacion = 'Bosque'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Especies en Hábitats Tropicales de Bosque ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar descripción de especies en hábitat tropical de bosque: " + e.getMessage());
        }
    }

    public void consultarCodigoLongitudItinerariosPasanMasTresZonas() {
        String sql = "SELECT I.id_itinerario, I.longitud FROM Itinerario I " +
                     "JOIN Itinerario_Zona IZ ON I.id_itinerario = IZ.id_itinerario " +
                     "GROUP BY I.id_itinerario, I.longitud " +
                     "HAVING COUNT(DISTINCT IZ.id_zona) > 3";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Itinerarios que Pasan por Más de Tres Zonas ---");
            while (rs.next()) {
                System.out.println("Itinerario ID: " + rs.getInt("id_itinerario") + ", Longitud: " + rs.getDouble("longitud"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar itinerarios por más de tres zonas: " + e.getMessage());
        }
    }

    public void listarNombresGuiasItinerariosDuranMenosUnaHora() {
        String sql = "SELECT DISTINCT G.nombre FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.duracion_minutos < 60";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Guías de Itinerarios de Menos de Una Hora ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar guías de itinerarios cortos: " + e.getMessage());
        }
    }

    public void obtenerFechaInicioGuiasItinerariosMaxDiezVisitantes() {
        String sql = "SELECT DISTINCT G.nombre, G.fecha_inicio FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.max_visitantes <= 10";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Fecha de Inicio de Guías de Itinerarios con Máx. 10 Visitantes ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre") + ", Fecha de Inicio: " + rs.getDate("fecha_inicio"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener fecha de inicio de guías de itinerarios con máx 10 visitantes: " + e.getMessage());
        }
    }

    public void mostrarEspeciesAtendidasPorCuidadorEspecificoTrabajaMasTresAnios(String nombreCuidador) {
        LocalDate tresAniosAtras = LocalDate.now().minus(3, ChronoUnit.YEARS);
        java.sql.Date sqlTresAniosAtras = java.sql.Date.valueOf(tresAniosAtras);

        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Animal A ON E.id_especie = A.id_especie " +
                     "JOIN PersonalCuidador PC ON A.id_personalcuidador = PC.id_cuidador " +
                     "WHERE PC.nombre = ? AND PC.fecha_ingreso < ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreCuidador);
            pstmt.setDate(2, sqlTresAniosAtras);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Especies Atendidas por Cuidador '" + nombreCuidador + "' (Más de 3 Años) ---");
                while (rs.next()) {
                    System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar especies por cuidador con más de 3 años: " + e.getMessage());
        }
    }

    public void consultarNombreCientificoEspeciesHabitatTempladoBosque() {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.clima = 'Templado' AND H.tipo_vegetacion = 'Bosque'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Nombres Científicos en Hábitat Templado de Bosque ---");
            while (rs.next()) {
                System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres científicos en hábitat templado de bosque: " + e.getMessage());
        }
    }

    public void listarHabitatsExtensionInferior(double areaMetrosCuadrados) {
        String sql = "SELECT nombre FROM Habitat WHERE extension < ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, areaMetrosCuadrados);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Hábitats con Extensión Inferior a " + areaMetrosCuadrados + " m² ---");
                while (rs.next()) {
                    System.out.println("Hábitat: " + rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar hábitats con extensión inferior: " + e.getMessage());
        }
    }

    public void obtenerNombreEspeciesZonasMenosTresEspecies() {
        String sql = "SELECT DISTINCT E.nombre_comun FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "JOIN Zona Z ON H.id_zona = Z.id_zona " +
                     "WHERE Z.id_zona IN (SELECT Z2.id_zona FROM Zona Z2 " +
                     "JOIN Habitat H2 ON Z2.id_zona = H2.id_zona " +
                     "JOIN Especie_Habitat EH2 ON H2.id_habitat = EH2.id_habitat " +
                     "GROUP BY Z2.id_zona HAVING COUNT(DISTINCT EH2.id_especie) < 3)";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Especies en Zonas con Menos de Tres Especies Diferentes ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener especies en zonas con menos de tres especies: " + e.getMessage());
        }
    }

    public void mostrarDescripcionEspeciesHabitatTropicalPradera() {
        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.clima = 'Tropical' AND H.tipo_vegetacion = 'Pradera'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Especies en Hábitats Tropicales de Pradera ---");
            while (rs.next()) {
                System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar descripción de especies en hábitat tropical de pradera: " + e.getMessage());
        }
    }

    public void consultarCodigoDuracionItinerariosPasanPorZona(String nombreZona) {
        String sql = "SELECT DISTINCT I.id_itinerario, I.duracion_minutos FROM Itinerario I " +
                     "JOIN Itinerario_Zona IZ ON I.id_itinerario = IZ.id_itinerario " +
                     "JOIN Zona Z ON IZ.id_zona = Z.id_zona " +
                     "WHERE Z.nombre = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreZona);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Itinerarios que Pasan por la Zona: " + nombreZona + " ---");
                while (rs.next()) {
                    System.out.println("Itinerario ID: " + rs.getInt("id_itinerario") + ", Duración: " + rs.getInt("duracion_minutos") + " minutos");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar itinerarios por zona específica: " + e.getMessage());
        }
    }

    public void listarNombresGuiasItinerariosMaxCincoVisitantes() {
        String sql = "SELECT DISTINCT G.nombre FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.max_visitantes <= 5";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Guías de Itinerarios con Máximo 5 Visitantes ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar guías de itinerarios con máx 5 visitantes: " + e.getMessage());
        }
    }

    public void obtenerFechaInicioGuiasItinerariosDuranMasCuatroHoras() {
        String sql = "SELECT DISTINCT G.nombre, G.fecha_inicio FROM Guia G " +
                     "JOIN Itinerario I ON G.id_guia = I.id_guia " +
                     "WHERE I.duracion_minutos > 240";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Fecha de Inicio de Guías de Itinerarios de Más de Cuatro Horas ---");
            while (rs.next()) {
                System.out.println("Guía: " + rs.getString("nombre") + ", Fecha de Inicio: " + rs.getDate("fecha_inicio"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener fecha de inicio de guías de itinerarios largos: " + e.getMessage());
        }
    }

    public void mostrarEspeciesAtendidasPorCuidadorEspecificoTrabajaMasCincoAnios(String nombreCuidador) {
        LocalDate cincoAniosAtras = LocalDate.now().minus(5, ChronoUnit.YEARS);
        java.sql.Date sqlCincoAniosAtras = java.sql.Date.valueOf(cincoAniosAtras);

        String sql = "SELECT DISTINCT E.nombre_comun, E.descripcion FROM Especie E " +
                     "JOIN Animal A ON E.id_especie = A.id_especie " +
                     "JOIN PersonalCuidador PC ON A.id_personalcuidador = PC.id_cuidador " +
                     "WHERE PC.nombre = ? AND PC.fecha_ingreso < ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreCuidador);
            pstmt.setDate(2, sqlCincoAniosAtras);
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- Especies Atendidas por Cuidador '" + nombreCuidador + "' (Más de 5 Años) ---");
                while (rs.next()) {
                    System.out.println("Especie: " + rs.getString("nombre_comun") + ", Descripción: " + rs.getString("descripcion"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar especies por cuidador con más de 5 años (específico): " + e.getMessage());
        }
    }


    public void consultarNombreCientificoEspeciesHabitatTropicalSabana() {
        String sql = "SELECT DISTINCT E.nombre_cientifico FROM Especie E " +
                     "JOIN Especie_Habitat EH ON E.id_especie = EH.id_especie " +
                     "JOIN Habitat H ON EH.id_habitat = H.id_habitat " +
                     "WHERE H.clima = 'Tropical' AND H.tipo_vegetacion = 'Sabana'";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Nombres Científicos en Hábitat Tropical de Sabana ---");
            while (rs.next()) {
                System.out.println("Nombre Científico: " + rs.getString("nombre_cientifico"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar nombres científicos en hábitat tropical de sabana: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ZooQueryExecutor executor = new ZooQueryExecutor();

        executor.mostrarNombreDescripcionTodasLasEspecies();
        executor.consultarNombreCientificoEspeciesHabitatTropical();
        executor.listarNombresHabitatsConClimaTipoVegetacion();
        executor.obtenerExtensionCadaZona();
        executor.mostrarCodigoDuracionTodosItinerarios();
        executor.consultarNumeroMaxVisitantesCadaItinerario();
        executor.listarNombresContactoTodosLosGuias();
        executor.obtenerNombresDireccionesCuidadores();
        executor.mostrarFechaInicioCadaGuia();
        executor.consultarNombreDescripcionEspeciesHabitatAcuatico();
        executor.listarNombresCientificosEspeciesHabitatSelva();
        executor.obtenerNombreEspeciesZonasClimaTropical();
        executor.mostrarNombreExtensionTodasLasZonas();
        executor.consultarCodigoLongitudItinerariosMayorDosHoras();
        executor.listarNombresGuiasLideranMasUnItinerario();
        executor.obtenerFechaIngresoTodosCuidadores();
        executor.mostrarInformacionContactoGuiasItinerarioMasLargo();
        executor.numeroEspeciesVisitadasCadaItinerario(); // Corregido: antes era consultarNumeroEspeciesVisitadasCadaItinerario
        executor.listarNombreCientificoEspeciesAtendidasPorCuidador("Juan Pérez"); // Ejemplo: Reemplaza con un nombre de cuidador real
        executor.obtenerNombreHabitatsVegetacionBosque();
        executor.mostrarDescripcionEspeciesZonasClimaTemplado();
        executor.consultarCodigoItinerarioMaxVisitantes();
        executor.listarNombresGuiasAsignadosItinerario("Safari Nocturno"); // Ejemplo: Reemplaza con un nombre de itinerario real
        executor.obtenerFechaInicioGuiasItinerariosCortos();
        executor.mostrarNombreDescripcionEspeciesAtendidasPorCuidadorParticular("María García"); // Ejemplo: Reemplaza con un nombre de cuidador real
        executor.consultarNombreCientificoEspeciesHabitatSabana();
        executor.listarHabitatsClimaTropicalTipoVegetacionSelva();
        executor.obtenerNombreEspeciesZonasExtensionSuperior(1000.0);
        executor.mostrarExtensionZonaEspecieParticular("León"); // Ejemplo: Reemplaza con un nombre común de especie real
        executor.consultarNumeroItinerariosAtraviesanZona("Zona Africana"); // Ejemplo: Reemplaza con un nombre de zona real
        executor.listarNombresGuiasItinerariosMayorTresHoras();
        executor.obtenerFechaIngresoCuidadoresAsignadosEspecie("Elefante"); // Ejemplo: Reemplaza con un nombre común de especie real
        executor.mostrarEspeciesAtendidasPorCuidadorIngresoMasCincoAnios();
        executor.consultarNombreCientificoEspeciesHabitatTempladoPradera();
        executor.listarHabitatsExtensionSuperior(500.0);
        executor.obtenerNombreEspeciesZonasMasCincoEspecies();
        executor.mostrarDescripcionEspeciesHabitatTropicalBosque();
        executor.consultarCodigoLongitudItinerariosPasanMasTresZonas();
        executor.listarNombresGuiasItinerariosDuranMenosUnaHora();
        executor.obtenerFechaInicioGuiasItinerariosMaxDiezVisitantes();
        executor.mostrarEspeciesAtendidasPorCuidadorEspecificoTrabajaMasTresAnios("Carlos Ruiz"); // Ejemplo: Reemplaza con un nombre de cuidador real
        executor.consultarNombreCientificoEspeciesHabitatTempladoBosque();
        executor.listarHabitatsExtensionInferior(200.0);
        executor.obtenerNombreEspeciesZonasMenosTresEspecies();
        executor.mostrarDescripcionEspeciesHabitatTropicalPradera();
        executor.consultarCodigoDuracionItinerariosPasanPorZona("Zona Asiática"); // Ejemplo: Reemplaza con un nombre de zona real
        executor.listarNombresGuiasItinerariosMaxCincoVisitantes();
        executor.obtenerFechaInicioGuiasItinerariosDuranMasCuatroHoras();
        executor.mostrarEspeciesAtendidasPorCuidadorEspecificoTrabajaMasCincoAnios("Ana López"); // Ejemplo: Reemplaza con un nombre de cuidador real
        executor.consultarNombreCientificoEspeciesHabitatTropicalSabana();
    }
}
