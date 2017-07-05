package com.github.jw3.gpsd4s


/**
 * see http://www.catb.org/gpsd/gpsd_json.html
 */
object Protocol {

  sealed trait GpsdModel

  case class TPV(tag: String,
                 device: String,
                 timestamp: Double,
                 timestampError: Double,
                 latitude: Double,
                 longitude: Double,
                 altitude: Double,
                 latitudeError: Double,
                 longitudeError: Double,
                 altitudeError: Double,
                 course: Double,
                 speed: Double,
                 climbRate: Double,
                 courseError: Double,
                 speedError: Double,
                 climbRateError: Double,
                 mode: NmeaMode
                ) extends GpsdModel

  case class SKY(tag: String,
                 device: String,
                 timestamp: Double,
                 longitudeDOP: Double,
                 latitudeDOP: Double,
                 altitudeDOP: Double,
                 timestampDOP: Double,
                 horizontalDOP: Double,
                 sphericalDOP: Double,
                 hypersphericalDOP: Double,
                 satellites: List[SAT]
                ) extends GpsdModel

  case class GST(tag: String,
                 device: String,
                 timestamp: Double,
                 rms: Double,
                 major: Double,
                 minor: Double,
                 orient: Double,
                 lat: Double,
                 lon: Double,
                 alt: Double
                ) extends GpsdModel

  case class ATT(tag: String,
                 device: String,
                 timestamp: Double,
                 heading: Double,
                 pitch: Double,
                 yaw: Double,
                 roll: Double,
                 dip: Double,
                 mag_len: Double,
                 mag_x: Double,
                 mag_y: Double,
                 mag_z: Double,
                 acc_len: Double,
                 acc_x: Double,
                 acc_y: Double,
                 acc_z: Double,
                 gyro_x: Double,
                 gyro_y: Double,
                 depth: Double,
                 temperature: Double,
                 magState: String,
                 pitchState: String,
                 yawState: String,
                 rollState: String
                ) extends

  case class Version(release: String,
                     rev: String,
                     protocolMajor: Double,
                     protocolMinor: Double
                    ) extends GpsdModel

  case class SAT(PRN: Int = -1,
                 azimuth: Int,
                 elevation: Int,
                 signalStrength: Int,
                 sed: Boolean = false
                ) extends GpsdModel

  case class Devices(devices: List[Device],
                     remove: String)

  case class Device(path: String,
                    activated: Double,
                    driver: String,
                    bps: Int,
                    parity: Parity,
                    stopbit: Int,
                    nativeMode: Boolean,
                    cycle: Double,
                    mincycle: Double
                   ) extends GpsdModel

  case class Poll(timestamp: Double,
                  active: Int,
                  fixes: List[TPV],
                  skyviews: List[SKY],
                  gst: List[GST]
                 ) extends GpsdModel

  sealed trait Parity
  case object NoParity extends Parity // "N"
  case object OddParity extends Parity // "O"
  case object EvenParity extends Parity // "E"

  sealed trait NmeaMode
  case object NotSeen extends NmeaMode
  case object NoFix extends NmeaMode
  case object TwoDimensional extends NmeaMode
  case object ThreeDimensional extends NmeaMode
}
