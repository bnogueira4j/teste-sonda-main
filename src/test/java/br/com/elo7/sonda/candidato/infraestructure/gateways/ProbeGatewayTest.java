//package br.com.elo7.sonda.candidato.infraestructure.gateways;
//
//import br.com.elo7.sonda.candidato.domain.probe.Probe;
//import br.com.elo7.sonda.candidato.infraestructure.gateways.ProbeGateway;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static br.com.elo7.sonda.candidato.domain.probe.Command.LEFT;
//import static br.com.elo7.sonda.candidato.domain.probe.Command.MOVE;
//import static br.com.elo7.sonda.candidato.domain.probe.Command.RIGHT;
//import static br.com.elo7.sonda.candidato.domain.probe.Direction.EAST;
//import static br.com.elo7.sonda.candidato.domain.probe.Direction.NORTH;
//import static br.com.elo7.sonda.candidato.domain.probe.Direction.SOUTH;
//import static br.com.elo7.sonda.candidato.domain.probe.Direction.WEST;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class ProbeGatewayTest {
//
//    @Autowired
//    private ProbeGateway subject;
//
//    @Test
//    public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {
//        Probe probe = new Probe();
//        probe.setDirection(NORTH);
//        subject.applyCommandToProbe(probe, LEFT);
//        assertEquals(WEST, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
//        Probe probe = new Probe();
//        probe.setDirection(WEST);
//        subject.applyCommandToProbe(probe, LEFT);
//        assertEquals(SOUTH, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
//        Probe probe = new Probe();
//        probe.setDirection(SOUTH);
//        subject.applyCommandToProbe(probe, LEFT);
//        assertEquals(EAST, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
//        Probe probe = new Probe();
//        probe.setDirection(EAST);
//        subject.applyCommandToProbe(probe, LEFT);
//        assertEquals(NORTH, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
//        Probe probe = new Probe();
//        probe.setDirection(NORTH);
//        subject.applyCommandToProbe(probe, RIGHT);
//        assertEquals(EAST, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
//        Probe probe = new Probe();
//        probe.setDirection(EAST);
//        subject.applyCommandToProbe(probe, RIGHT);
//        assertEquals(SOUTH, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {
//        Probe probe = new Probe();
//        probe.setDirection(SOUTH);
//        subject.applyCommandToProbe(probe, RIGHT);
//        assertEquals(WEST, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
//        Probe probe = new Probe();
//        probe.setDirection(WEST);
//        subject.applyCommandToProbe(probe, RIGHT);
//        assertEquals(NORTH, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
//        Probe probe = new Probe();
//        probe.setPositionX(1);
//        probe.setPositionY(1);
//        probe.setDirection(NORTH);
//        subject.applyCommandToProbe(probe, MOVE);
//        assertEquals(2, probe.getPositionY());
//        assertEquals(1, probe.getPositionX());
//        assertEquals(NORTH, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
//        Probe probe = new Probe();
//        probe.setPositionX(1);
//        probe.setPositionY(1);
//        probe.setDirection(SOUTH);
//        subject.applyCommandToProbe(probe, MOVE);
//        assertEquals(0, probe.getPositionY());
//        assertEquals(1, probe.getPositionX());
//        assertEquals(SOUTH, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
//        Probe probe = new Probe();
//        probe.setPositionX(1);
//        probe.setPositionY(1);
//        probe.setDirection(WEST);
//        subject.applyCommandToProbe(probe, MOVE);
//        assertEquals(0, probe.getPositionX());
//        assertEquals(1, probe.getPositionY());
//        assertEquals(WEST, probe.getDirection());
//    }
//
//    @Test
//    public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
//        Probe probe = new Probe();
//        probe.setPositionX(1);
//        probe.setPositionY(1);
//        probe.setDirection(EAST);
//        subject.applyCommandToProbe(probe, MOVE);
//        assertEquals(2, probe.getPositionX());
//        assertEquals(1, probe.getPositionY());
//        assertEquals(EAST, probe.getDirection());
//    }
//}
